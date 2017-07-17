package model;

/**
 * Created by 123 on 2017/07/05.
 */
public class userinfo {
    private int UserCode;
    private String UserName;
    private String UserPwd;
    private String LastLoginTime;
    private int IsUse;
    private String Ip;

    public userinfo() {
    }

    public userinfo(int userCode, String userName, String userPwd, String lastLoginTime, int isUse, String ip) {
        UserCode = userCode;
        UserName = userName;
        UserPwd = userPwd;
        LastLoginTime = lastLoginTime;
        IsUse = isUse;
        Ip = ip;
    }

    public int getUserCode() {
        return UserCode;
    }

    public void setUserCode(int userCode) {
        UserCode = userCode;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserPwd() {
        return UserPwd;
    }

    public void setUserPwd(String userPwd) {
        UserPwd = userPwd;
    }

    public String getLastLoginTime() {
        return LastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        LastLoginTime = lastLoginTime;
    }

    public int getIsUse() {
        return IsUse;
    }

    public void setIsUse(int isUse) {
        IsUse = isUse;
    }

    public String getIp() {
        return Ip;
    }

    public void setIp(String ip) {
        Ip = ip;
    }
}
