package cn.edu.neu.bean.domain;

/**
 * @author liyu
 */
public class DayView {

    private int id;
    private int num;
    private int year;
    private int month;
    private int day;

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

    @Override
    public String toString() {
        return "DayView{" +
                "id=" + id +
                ", num=" + num +
                ", year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
