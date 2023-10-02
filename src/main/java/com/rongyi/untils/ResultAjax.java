package com.rongyi.untils;

import java.io.Serializable;

public class ResultAjax<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final int SUCCESS = 200;

    private static final int ERROR = 500;

    private int code;

    private String msg;

    private T data;

    public static <T> ResultAjax<T> success(){
        return restResult(null,SUCCESS,"success");
    }
    public static <T> ResultAjax<T> success(T data){
        return restResult(data,SUCCESS,"success");
    }
    public static <T> ResultAjax<T> success(T data,String msg){
        return restResult(data,SUCCESS,msg);
    }

    public static <T> ResultAjax<T> error(){
        return restResult(null,ERROR,"error");
    }
    public static <T> ResultAjax<T> error(String msg){
        return restResult(null,ERROR,msg);
    }
    public static <T> ResultAjax<T> error(T data){
        return restResult(data,ERROR,"fail");
    }
    public static <T> ResultAjax<T> error(T data,String msg){
        return restResult(data,ERROR,msg);
    }
    public static <T> ResultAjax<T> error(int code,String msg){
        return restResult(null,code,msg);
    }

    private static <T> ResultAjax<T> restResult(T data,int code,String msg){
        ResultAjax<T> apiResult= new ResultAjax<>();
        apiResult.setCode(code);
        apiResult.setMsg(msg);
        apiResult.setData(data);
        return apiResult;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
