package cn.edu.neu;

import cn.edu.neu.tlog.manager.LogManager;

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

        try {
            while (true) {
                logManager.updateLog();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {

        } finally {
            logManager.close();
        }
    }
}
