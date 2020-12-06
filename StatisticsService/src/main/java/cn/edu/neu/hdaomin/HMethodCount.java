package cn.edu.neu.hdaomin;

/**
 * @author liyu
 */
public class HMethodCount {
    private String method;
    private int count;

    @Override
    public String toString() {
        return "HMethodCounts{" +
                "method='" + method + '\'' +
                ", count=" + count +
                '}';
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
