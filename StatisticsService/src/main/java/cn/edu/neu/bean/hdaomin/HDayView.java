package cn.edu.neu.bean.hdaomin;

/**
 * @author liyu
 */
public class HDayView {
    private int year;
    private int month;
    private int day;
    private int count;

    public HDayView(int year, int month, int day, int count) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.count = count;
    }

    @Override
    public String toString() {
        return "HDayView{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", count=" + count +
                '}';
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
