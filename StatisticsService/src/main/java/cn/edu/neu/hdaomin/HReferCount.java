package cn.edu.neu.hdaomin;

/**
 * @author liyu
 */
public class HReferCount {
    private String refer;
    private int count;

    @Override
    public String toString() {
        return "HReferCount{" +
                "refer='" + refer + '\'' +
                ", count=" + count +
                '}';
    }

    public String getRefer() {
        return refer;
    }

    public void setRefer(String refer) {
        this.refer = refer;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
