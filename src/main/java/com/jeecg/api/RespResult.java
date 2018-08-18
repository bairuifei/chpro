package com.jeecg.api;

/**
 * 基础响应内容封装类
 */
public class RespResult {
    private int ret;
    private String errorCode;
    private String errorMsg;
    private Object data;

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public RespResult() {
    }

    public RespResult(int ret, String errorCode, String errorMsg, Object data) {
        this.ret = ret;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.data = data;
    }
}
