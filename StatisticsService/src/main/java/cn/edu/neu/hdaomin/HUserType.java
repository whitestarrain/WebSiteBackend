package cn.edu.neu.hdaomin;

/**
 * @author liyu
 */
public class HUserType {
    private int userId;
    private int isOldUser;

    @Override
    public String toString() {
        return "HUserType{" +
                "userId=" + userId +
                ", isOldUser=" + isOldUser +
                '}';
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
