package cn.edu.neu.service;

import cn.edu.neu.dao.hdao.HiveDao;
import cn.edu.neu.dao.mdao.MysqlDao;
import cn.edu.neu.hdaomin.*;

import java.util.List;

/**
 * @author liyu
 */
public class UpdateService {
    private MysqlDao mdao = new MysqlDao();
    private HiveDao hdao = new HiveDao();

    private void updateAgentCount(int num) {
        List<HAgentCount> hAgentCountList = hdao.calculateAgentCount();
        mdao.insertAgentCount(num, hAgentCountList);
    }

    private void updateCityCount(int num) {
        List<HCityCount> hCityCountList = hdao.calculateCityCounts();
        mdao.insertCityCount(num, hCityCountList);
    }

    private void updateCityFlow(int num) {
        // hive 执行mapreduce任务，返回结果，将结果封装到实体类中
        List<HCityFlow> HCityFlowList = hdao.calculateCityFlow();
        // 将结果传给mysql的dao对象的方法，把结果存入mysql
        mdao.insertCityFlow(num, HCityFlowList);
    }

    private void updateMethodCount(int num) {
        List<HMethodCount> hMethodCountList = hdao.calculateMethodCount();
        mdao.insertMethodCount(num, hMethodCountList);
    }

    private void updateStatusCount(int num) {
        List<HStatusCount> hStatusCountList = hdao.calculateStatusCount();
        mdao.insertStatusCount(num, hStatusCountList);
    }

    private void updateHUserType(int num) {
        List<HUserType> hUserTypeList = hdao.calculateUserType();
        mdao.insertUserType(num, hUserTypeList);
    }

    private void updateReferCount(int num) {
        List<HReferCount> hReferCountList = hdao.calculateReferCount();
        mdao.insertReferCount(num, hReferCountList);
    }

    public void addDayView(int year, int month, int day) {
        System.out.println("添加" + year + "-" + month + "-" + day + "日访问量数据");
        boolean isExist = mdao.dayFlowIsExist(year, month, day);
        if (isExist) {
            // 若存在，就不进行添加记录
            return;
        }
        int count = hdao.calculateDayView(year, month, day);
        mdao.addDayView(new HDayView(year, month, day, count));
    }


    public void updateAll() {
        System.out.println("统计数据更新");
        int num = mdao.getNextNum();
        System.out.println("  -- 更新agent统计");
        this.updateAgentCount(num);

        System.out.println("  -- 更新访客地区统计");
        this.updateCityCount(num);

        System.out.println("  -- 更新流量统计");
        this.updateCityFlow(num);

        System.out.println("  -- 更新请求方法统计");
        this.updateMethodCount(num);

        System.out.println("  -- 更新响应状态统计");
        this.updateStatusCount(num);

        System.out.println("  -- 更新用户类别统计");
        this.updateHUserType(num);

        System.out.println("  -- 更新访问refer统计");
        this.updateReferCount(num);
    }


    public void repairMetadata() {
        hdao.repairMetadata();
    }

}
