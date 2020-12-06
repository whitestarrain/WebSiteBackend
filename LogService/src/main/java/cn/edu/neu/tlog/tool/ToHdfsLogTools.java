package cn.edu.neu.tlog.tool;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liyu
 * 用来记录与hdfs的交互记录
 */
public class ToHdfsLogTools {
    private static String tempLog;
    private static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss:SSS'Z'");

    public static void logOfAppend(File file, long length) {
        tempLog = "[" + sdf2.format(new Date()) + "]append to " + file.getName() + " " + length + " " +
                "bytes";
        System.out.println(tempLog);
    }

    public static void logOfUpload(File file) {
        tempLog = "[" + sdf2.format(new Date()) + "]upload file " + file.getName();
        System.out.println(tempLog);
    }

    public static void logOfNothing(File file) {
        tempLog = "[" + sdf2.format(new Date()) + "]nothing to do for " + file.getName();
        System.out.println(tempLog);
    }
}
