package cn.edu.neu.conf;

import org.yaml.snakeyaml.Yaml;

import java.util.Map;

/**
 * @author liyu
 */
public class SqlContainer {
    public static Map<String, Map<String,String>> sqlMap;

    static {
        sqlMap = new Yaml().loadAs(SqlContainer.class.getClassLoader().getResourceAsStream("sql.yaml"), Map.class);
    }
}
