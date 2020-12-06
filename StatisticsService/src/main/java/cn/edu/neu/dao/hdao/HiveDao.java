package cn.edu.neu.dao.hdao;

import cn.edu.neu.conf.SqlContainer;
import cn.edu.neu.dao.utils.HiveJdbcUtils;
import cn.edu.neu.hdaomin.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author liyu
 */
public class HiveDao {
    JdbcTemplate jdbc = new JdbcTemplate(HiveJdbcUtils.getDataSourse());

    public List<HCityFlow> calculateCityFlow() {
        return jdbc.query(SqlContainer.sqlMap.get("hive").get("calculateCityFlow"),
                new BeanPropertyRowMapper<HCityFlow>(HCityFlow.class));
    }

    public List<HAgentCount> calculateAgentCount() {
        return jdbc.query(SqlContainer.sqlMap.get("hive").get("calculateAgentCount"),
                new BeanPropertyRowMapper<HAgentCount>(HAgentCount.class));
    }

    public List<HCityCount> calculateCityCounts() {
        return jdbc.query(SqlContainer.sqlMap.get("hive").get("calculateCityCounts"),
                new BeanPropertyRowMapper<HCityCount>(HCityCount.class));
    }

    public List<HMethodCount> calculateMethodCount() {
        return jdbc.query(SqlContainer.sqlMap.get("hive").get("calculateMethodCount"),
                new BeanPropertyRowMapper<HMethodCount>(HMethodCount.class));
    }

    public List<HStatusCount> calculateStatusCount() {
        return jdbc.query(SqlContainer.sqlMap.get("hive").get("calculateStatusCount"),
                new BeanPropertyRowMapper<HStatusCount>(HStatusCount.class));

    }

    public List<HUserType> calculateUserType() {
        return jdbc.query(SqlContainer.sqlMap.get("hive").get("calculateUserType"),
                new BeanPropertyRowMapper<HUserType>(HUserType.class));
    }

    public int calculateDayView(int year, int month, int day) {
        List<Integer> integers = jdbc.queryForList(SqlContainer.sqlMap.get("hive").get("calculateDayView"),
                new Object[]{year, month,
                        day}, Integer.class);
        if (integers.size() == 0) {
            return 0;
        }
        return integers.get(0);
    }

    public List<HReferCount> calculateReferCount() {
        return jdbc.query(SqlContainer.sqlMap.get("hive").get("calculateReferCount"),
                new BeanPropertyRowMapper<HReferCount>(HReferCount.class));
    }

    public void repairMetadata() {
        jdbc.execute(SqlContainer.sqlMap.get("hive").get("repairMetadata"));
    }

}
