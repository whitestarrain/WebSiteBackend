package cn.edu.neu.tlog.manager;

import cn.edu.neu.tlog.tool.FileScanner;
import cn.edu.neu.tlog.tool.HdfsTools;
import cn.edu.neu.tlog.tool.ToHdfsLogTools;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * @author liyu
 */
public class LogManager {
    private Configuration conn = null;
    /**
     * 与hdfs连接交互
     */
    private FileSystem fs = null;
    /**
     * 用来扫描所有文件，获取日志文件
     */
    private FileScanner fscan = null;
    /**
     * log文件路径
     */
    private String filesPath;
    /**
     * log文件 匹配正则表达式
     */
    private String reg;
    /**
     * hdfs存放log的路径，最后一定要带 /
     */
    private String remoteDir;
    /**
     * hdfs 服务器uri
     */
    private String uri;
    /**
     * 以哪个用户名进行远程登陆hdfs
     */
    private String userName;

    public LogManager(String filesPath, String reg, String remoteDir, String uri, String userName) {
        this.filesPath = filesPath;
        this.reg = reg;
        // remoteDir应该是一个文件夹路径
        if (remoteDir.endsWith("/")) {
            this.remoteDir = remoteDir;
        } else {
            this.remoteDir = remoteDir + "/";
        }
        this.uri = uri;
        this.userName = userName;
        connection();
    }

    private void connection() {
        this.conn = new Configuration();
        URI uri = null;
        try {
            uri = new URI(this.uri);
            fs = FileSystem.get(uri, conn, this.userName);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateLog() {
        // 追加数据总长度
        long appendSum = 0;
        // 添加的日志文件
        ArrayList<File> list = new ArrayList<File>();

        if (fscan == null) {
            fscan = new FileScanner(filesPath, reg);
        }
        File[] files = fscan.scan();
        for (File file : files) {
            if (file.isDirectory()) {
                continue;
            }
            try {
                if (HdfsTools.isExist(fs, file, remoteDir)) {
                    long remoteLength = HdfsTools.getLen(fs, file, remoteDir);
                    if (remoteLength < file.length()) {
                        long appendLong = file.length() - remoteLength;
                        appendSum += appendLong;
                        ToHdfsLogTools.logOfAppend(file, appendLong);
                        HdfsTools.appendFile(fs, file, remoteLength, remoteDir);
                    }
                } else {
                    list.add(file);
                    ToHdfsLogTools.logOfUpload(file);
                    HdfsTools.uploadFile(fs, file, remoteDir);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 上传文件一定会触发数据的统计和日访问量的添加
        if (list.size()> 0) {
            // 检查修复元数据
            StaticManager.repairMetadata();
            StaticManager.updateAll();
            for (File file : list) {
                // 对过去一天的数据进行统计
                StaticManager.addFileJudge(file);
            }
        } else {
            // 如果不上传文件，添加数据超过指定大小，才会触发统计
            StaticManager.appendJudge(appendSum);
        }
    }

    public void close() {
        try {
            this.fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
