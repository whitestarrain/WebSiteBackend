package cn.edu.neu.bean.domain;

/**
 * @author liyu
 */
public class CityFlow {
    private int id;
    private int num;
    private String city;
    private double sum_flow;

    @Override
    public String toString() {
        return "CityFlow{" +
                "id=" + id +
                ", num=" + num +
                ", city='" + city + '\'' +
                ", sum_flow=" + sum_flow +
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

    public double getSum_flow() {
        return sum_flow;
    }

    public void setSum_flow(double sum_flow) {
        this.sum_flow = sum_flow;
    }
}
