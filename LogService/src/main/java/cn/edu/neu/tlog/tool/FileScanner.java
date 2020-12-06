package cn.edu.neu.tlog.tool;

import cn.edu.neu.tlog.filter.FileFilter;

import java.io.File;
import java.util.Arrays;

/**
 * @author liyu
 */
public class FileScanner {
    private String filesPath;
    private String reg;
    public FileScanner(String filesPath,String reg) {
        this.filesPath = filesPath;
        this.reg = reg;
    }

    public File[] scan() {
        File file = new File(filesPath);
        File[] files = file.listFiles();
        return Arrays.stream(files).
                 filter(new FileFilter(reg)).
                toArray(File[]::new);
    }
}
