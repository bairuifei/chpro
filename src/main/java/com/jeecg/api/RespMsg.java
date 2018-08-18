package com.jeecg.api;

/**
 * 相应信息枚举
 */
public enum RespMsg {
    SUCCESS("000","成功"),
    FAIL("111","失败"),
    ;
    private String code;
    private String msg;

    RespMsg(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
