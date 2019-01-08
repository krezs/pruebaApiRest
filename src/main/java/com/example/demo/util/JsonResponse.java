package com.example.demo.util;

import java.util.List;

public class JsonResponse<T> {
    String msg = "";
    boolean error = false;
    List<T> data = null;

    public JsonResponse() {

    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
