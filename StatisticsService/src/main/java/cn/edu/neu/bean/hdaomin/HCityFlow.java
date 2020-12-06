package cn.edu.neu.bean.hdaomin;

/**
 * @author liyu
 */
public class HCityFlow {
    private String city;
    private double sumFlow;

    @Override
    public String toString() {
        return "HCityFlow{" +
                "city='" + city + '\'' +
                ", sumFlow=" + sumFlow +
                '}';
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getSumFlow() {
        return sumFlow;
    }

    public void setSumFlow(double sumFlow) {
        this.sumFlow = sumFlow;
    }
}
