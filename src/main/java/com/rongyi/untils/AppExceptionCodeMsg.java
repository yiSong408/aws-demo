package com.rongyi.untils;

public enum AppExceptionCodeMsg {
    // Exception related with service
    Username_PASSWORD_INCORRECT(10000,"username or password not correct");

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    AppExceptionCodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
