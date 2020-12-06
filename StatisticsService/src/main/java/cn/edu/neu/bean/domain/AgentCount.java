package cn.edu.neu.bean.domain;

/**
 * @author liyu
 */
public class AgentCount {

    private int id;
    private int sum;
    private String agent;
    private int count;

    @Override
    public String toString() {
        return "AgentCount{" +
                "id=" + id +
                ", sum=" + sum +
                ", agent='" + agent + '\'' +
                ", count=" + count +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }
}
