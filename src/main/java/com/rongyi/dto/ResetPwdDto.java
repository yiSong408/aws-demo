package com.rongyi.dto;

public class ResetPwdDto {
    private String password;
    private String uid;

    public ResetPwdDto() {
    }

    public ResetPwdDto(String password, String uid) {
        this.password = password;
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "ResetPwdDto{" +
                "password='" + password + '\'' +
                ", uid='" + uid + '\'' +
                '}';
    }
}
