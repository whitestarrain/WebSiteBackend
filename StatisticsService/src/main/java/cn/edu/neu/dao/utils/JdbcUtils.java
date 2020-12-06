package cn.edu.neu.dao.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author liyu
 */
public class JdbcUtils {
    private static DataSource ds;
    static{
        //加载properties对象
        Properties pro=new Properties();
        InputStream inputStream=JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            pro.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //通过工厂类读取pro，并创建对应的DataSouce
        try {
           ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static DataSource getDataSourse(){
        return  ds;
    }

}
