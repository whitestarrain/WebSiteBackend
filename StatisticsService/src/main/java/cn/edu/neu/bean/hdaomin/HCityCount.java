package cn.edu.neu.bean.hdaomin;

/**
 * @author liyu
 */
public class HCityCount {
    private String city;
    private int count;

    @Override
    public String toString() {
        return "HCityCounts{" +
                "city='" + city + '\'' +
                ", count=" + count +
                '}';
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
