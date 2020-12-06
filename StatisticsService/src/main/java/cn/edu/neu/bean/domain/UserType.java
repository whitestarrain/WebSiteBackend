package cn.edu.neu.bean.domain;

/**
 * @author liyu
 */
public class UserType {
    private int id;
    private int num;
    private int userId;
    private int isOldUser;

    @Override
    public String toString() {
        return "UserType{" +
                "id=" + id +
                ", num=" + num +
                ", userId=" + userId +
                ", isOldUser=" + isOldUser +
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getIsOldUser() {
        return isOldUser;
    }

    public void setIsOldUser(int isOldUser) {
        this.isOldUser = isOldUser;
    }
}
