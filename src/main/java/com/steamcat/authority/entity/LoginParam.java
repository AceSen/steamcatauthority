package com.steamcat.authority.entity;

/**
 * @ClassName LonginParam
 * @Description TODO
 * @Author Administrator
 * @Data 下午 09:14
 * @Version 1.0
 **/
public class LoginParam {
    private String userName;
    private String passWord;
    private String mobileCode;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getMobileCode() {
        return mobileCode;
    }

    public void setMobileCode(String mobileCode) {
        this.mobileCode = mobileCode;
    }
}
