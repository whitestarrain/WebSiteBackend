package cn.edu.neu.tlog.filter;

import java.io.File;
import java.util.function.Predicate;

/**
 * @author liyu
 * 用来过滤掉非tomcat日志文件的类
 */
public class FileFilter implements Predicate<File> {
    private String reg;
    public FileFilter(String reg){
        this.reg=reg;
    }

    @Override
    public boolean test(File file) {
        return file.getName().matches(reg);
    }
}
