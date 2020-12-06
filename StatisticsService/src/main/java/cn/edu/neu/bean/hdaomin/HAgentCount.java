package cn.edu.neu.bean.hdaomin;

/**
 * @author liyu
 */
public class HAgentCount {
    private String agent;
    private int count;

    @Override
    public String toString() {
        return "HAgentCount{" +
                "agent='" + agent + '\'' +
                ", count=" + count +
                '}';
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
