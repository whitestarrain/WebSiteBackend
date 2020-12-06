package cn.edu.neu.bean.domain;

/**
 * @author liyu
 */
public class CityCounts {
    private int id;
    private int num;
    private String city;
    private int count;

    @Override
    public String toString() {
        return "CityCounts{" +
                "id=" + id +
                ", num=" + num +
                ", city='" + city + '\'' +
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
