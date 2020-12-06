package cn.edu.neu.tlog.tool;

import cn.edu.neu.tlog.conf.Configuration;
import cn.edu.neu.tlog.manager.StaticManager;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author liyu
 */
public class HdfsTools {

    private static String getPath(File file, String remoteDir) {
        String name = file.getName();
        Matcher m = Pattern.compile(Configuration.REGEX_YEAR_MONTH).matcher(name);
        m.find();
        String year = m.group(1);
        String month = m.group(2);
        return remoteDir + "year=" + year + "/" + "month=" + month + "/" + name;
    }

    public static boolean isExist(FileSystem fs, File file, String remoteDir) throws IOException {
        return fs.exists(new Path(getPath(file, remoteDir)));
    }

    /**
     * @param fs
     * @param file
     * @param remoteDir 最后一定要有 /
     * @throws IOException
     */
    public static void uploadFile(FileSystem fs, File file, String remoteDir) throws IOException {
        Path path = new Path(getPath(file, remoteDir));
        FSDataOutputStream fsDataOutputStream = fs.create(path);
        InputStream in = new BufferedInputStream(new FileInputStream(file));
        IOUtils.copyBytes(in, fsDataOutputStream, fs.getConf(), true);
    }

    /**
     * 讲新的日志数据append到hdfs上
     *
     * @param fs
     * @param file
     * @param seek      从本地文件哪里开始上传
     * @param remoteDir 最后一定要有 /
     */
    public static void appendFile(FileSystem fs, File file, long seek, String remoteDir) throws IOException {
        Path path = new Path(getPath(file, remoteDir));
        FSDataOutputStream out = fs.append(path);
        InputStream in = new BufferedInputStream(new FileInputStream(file));
        // 跳过远端已经有的数据
        in.skip(seek);
        IOUtils.copyBytes(in, out, fs.getConf(), true);
    }

    public static Long getLen(FileSystem fs, File file, String remoteDir) throws IOException {
        return fs.getFileStatus(new Path(getPath(file, remoteDir))).getLen();
    }
}
