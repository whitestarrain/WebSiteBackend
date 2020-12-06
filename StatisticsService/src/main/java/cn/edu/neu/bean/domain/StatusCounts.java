package cn.edu.neu.bean.domain;

/**
 * @author liyu
 */
public class StatusCounts {
    private int id;
    private int num;
    private int status;
    private int count;

    @Override
    public String toString() {
        return "StatusCounts{" +
                "id=" + id +
                ", num=" + num +
                ", status=" + status +
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
