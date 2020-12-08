package cn.edu.neu.hdaomin;

/**
 * @author liyu
 */
public class HUserCount {
    private int userCount;
    private int visitorCount;

    @Override
    public String toString() {
        return "HUserCount{" +
                "userCount=" + userCount +
                ", visitorCount=" + visitorCount +
                '}';
    }

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }

    public int getVisitorCount() {
        return visitorCount;
    }

    public void setVisitorCount(int visitorCount) {
        this.visitorCount = visitorCount;
    }
}
