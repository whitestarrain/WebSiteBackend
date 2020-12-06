package cn.edu.neu.dao.mdao;

import cn.edu.neu.conf.SqlContainer;
import cn.edu.neu.dao.utils.JdbcUtils;
import cn.edu.neu.hdaomin.*;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author liyu
 */
public class MysqlDao {
    JdbcTemplate jdbc = new JdbcTemplate(JdbcUtils.getDataSourse());

    public int getNextNum() {
        // 添加一个id,id和时间戳都是自动生成
        jdbc.execute(SqlContainer.sqlMap.get("mysql").get("getNextNum1"));
        Integer integer = jdbc.queryForObject(SqlContainer.sqlMap.get("mysql").get("getNextNum2"), Integer.class);
        return integer.intValue();
    }


    public void insertCityFlow(int num, List<HCityFlow> hCityFlowList) {
        String sql = SqlContainer.sqlMap.get("mysql").get("insertCityFlow");
        for (HCityFlow hCityFlow : hCityFlowList) {
            jdbc.update(sql, num, hCityFlow.getCity(), hCityFlow.getSumFlow());
        }
    }

    public void insertAgentCount(int num, List<HAgentCount> hAgentCountList) {
        String sql = SqlContainer.sqlMap.get("mysql").get("insertAgentCount");
        for (HAgentCount hAgentCount : hAgentCountList) {
            jdbc.update(sql, num, hAgentCount.getAgent(), hAgentCount.getCount());
        }
    }

    public void insertCityCount(int num, List<HCityCount> hCityCountList) {
        String sql = SqlContainer.sqlMap.get("mysql").get("insertCityCount");
        for (HCityCount hCityCount : hCityCountList) {
            jdbc.update(sql, num, hCityCount.getCity(), hCityCount.getCount());
        }
    }

    public void insertMethodCount(int num, List<HMethodCount> hMethodCountList) {
        String sql = SqlContainer.sqlMap.get("mysql").get("insertMethodCount");
        for (HMethodCount hMethodCount : hMethodCountList) {
            jdbc.update(sql, num, hMethodCount.getMethod(), hMethodCount.getCount());
        }
    }

    public void insertStatusCount(int num, List<HStatusCount> hStatusCountList) {
        String sql = SqlContainer.sqlMap.get("mysql").get("insertStatusCount");
        for (HStatusCount hStatusCount : hStatusCountList) {
            jdbc.update(sql, num, hStatusCount.getStatus(), hStatusCount.getCount());
        }
    }

    public void insertUserType(int num, List<HUserType> hUserTypeList) {
        String sql = SqlContainer.sqlMap.get("mysql").get("insertUserType");
        for (HUserType hUserType : hUserTypeList) {
            jdbc.update(sql, num, hUserType.getUserId(), hUserType.getIsOldUser());
        }
    }

    public void insertReferCount(int num, List<HReferCount> hReferCountList) {
        String sql = SqlContainer.sqlMap.get("mysql").get("insertReferCount");
        for (HReferCount hReferCount : hReferCountList) {
            jdbc.update(sql, num, hReferCount.getRefer(), hReferCount.getCount());
        }
    }


    public void addDayView(HDayView hDayView) {
        String sql = SqlContainer.sqlMap.get("mysql").get("addDayView");
        jdbc.update(sql, hDayView.getYear(), hDayView.getMonth(), hDayView.getDay(), hDayView.getCount());
    }


    public boolean dayFlowIsExist(int year, int month, int day) {
        String sql = SqlContainer.sqlMap.get("mysql").get("dayFlowIsExist");
        Integer i = jdbc.queryForObject(sql, Integer.class, year, month, day);
        return i > 0;
    }

}
