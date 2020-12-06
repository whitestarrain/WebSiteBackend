package cn.edu.neu;

import cn.edu.neu.tlog.manager.LogManager;
import cn.edu.neu.tlog.Switcher;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author liyu
 */
public class LogUploadMain {

    public static void main(String[] args) {
        Properties pro = new Properties();
        LogManager logManager = null;

        // 开启一个等待输入的进程，用来结束整个循环
        new Thread(new Switcher()).start();
        try {
            InputStream in = LogUploadMain.class.getClassLoader().getResourceAsStream("configuration.property");
            if (in != null) {
                pro.load(in);
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        logManager = new LogManager(pro.getProperty("logPath"),
                pro.getProperty("reg"), pro.getProperty("remotePath")
                , pro.getProperty("hdfsUri"), pro.getProperty("userName"));

        while (Switcher.toggle) {
            logManager.updateLog();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        logManager.close();
    }
}
