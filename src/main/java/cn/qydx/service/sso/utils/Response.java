package cn.qydx.service.sso.utils;

import com.alibaba.fastjson.annotation.JSONField;

public class Response<T> {
	
	@JSONField
    private T data;
    private int code;
    private String msg;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
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


    public Response(T data, int code) {
        this.data = data;
        this.code = code;
    }

}
