package cn.edu.neu.bean.domain;

/**
 * @author liyu
 */
public class MethodCounts {

    private int id;
    private int num;
    private String method;
    private int count;

    @Override
    public String toString() {
        return "MethodCounts{" +
                "id=" + id +
                ", num=" + num +
                ", method='" + method + '\'' +
                ", count=" + count +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
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
