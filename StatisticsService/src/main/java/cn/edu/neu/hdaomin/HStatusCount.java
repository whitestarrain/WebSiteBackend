package cn.edu.neu.hdaomin;

/**
 * @author liyu
 */
public class HStatusCount {
    private int status;
    private int count;

    @Override
    public String toString() {
        return "HstatusCounts{" +
                "status=" + status +
                ", count=" + count +
                '}';
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
