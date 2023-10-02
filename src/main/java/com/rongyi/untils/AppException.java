package com.rongyi.untils;

public class AppException extends RuntimeException{
    private int code = 500;
    private String msg = "service exception";

    public AppException(AppExceptionCodeMsg appExceptionCodeMsg) {
        super();
        this.code=appExceptionCodeMsg.getCode();
        this.msg=appExceptionCodeMsg.getMsg();
    }

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

    @Override
    public String toString() {
        return "AppException{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
