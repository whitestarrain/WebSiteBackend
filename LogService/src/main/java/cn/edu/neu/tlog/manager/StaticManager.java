package cn.edu.neu.tlog.manager;

import cn.edu.neu.service.UpdateService;
import cn.edu.neu.tlog.conf.Configuration;

import java.io.File;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author liyu
 */
public class StaticManager {
    private static UpdateService updateService = new UpdateService();

    public static void updateAll() {
        updateService.updateAll();
    }

    public static void appendJudge(long appendByteLong) {
        if (appendByteLong > Configuration.MAX_APPEND_LENGTH) {
            System.out.println(appendByteLong);
            updateService.updateAll();
        }
    }

    public static void addFileJudge(File file) {
        // 有日志文件上传的话，就是新的一天的。
        // 那就开始统计之前一天的访问量
        String name = file.getName();
        Matcher m = Pattern.compile(Configuration.REGEX_YEAR_MONTH_DAY).matcher(name);
        m.find();
        Calendar ca = Calendar.getInstance();
        ca.set(Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2)), Integer.parseInt(m.group(3)));
        ca.add(Calendar.DATE, -1);
        updateService.addDayView(ca.get(Calendar.YEAR), ca.get(Calendar.MONTH), ca.get(Calendar.DATE));
    }

    public static void repairMetadata() {
        updateService.repairMetadata();
    }
}
