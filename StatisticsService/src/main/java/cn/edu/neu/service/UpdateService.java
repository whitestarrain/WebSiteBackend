package cn.edu.neu.service;

import cn.edu.neu.bean.hdaomin.*;
import cn.edu.neu.dao.hdao.HiveDao;
import cn.edu.neu.dao.mdao.MysqlDao;

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
        List<HUserType> hUserTypeList = hdao.calculateHUserType();
        mdao.insertUserType(num, hUserTypeList);
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
        this.updateAgentCount(num);
        this.updateCityCount(num);
        this.updateCityFlow(num);
        this.updateMethodCount(num);
        this.updateStatusCount(num);
        this.updateHUserType(num);
    }

    public void repairMetadata() {
        hdao.repairMetadata();
    }

}
