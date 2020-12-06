package cn.edu.neu.tlog.conf;

/**
 * @author liyu
 */
public class Configuration {
    public static final String REGEX_YEAR_MONTH = ".+\\.(\\d{4})-(\\d{2})-\\d{2}\\.(log|txt)";
    public static final String REGEX_YEAR_MONTH_DAY = ".+\\.(\\d{4})-(\\d{2})-(\\d{2})\\.(log|txt)";
    public static final long MAX_APPEND_LENGTH = 1024 * 1024 * 1024;
}
