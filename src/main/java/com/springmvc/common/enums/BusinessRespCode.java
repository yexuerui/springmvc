package com.springmvc.common.enums;

/**
 * @ClassName BusinessRespCode
 * @Description 业务响应枚举类
 * @Author xueruiye
 * @Date 2019/5/13
 * @Version 1.0
 **/
public enum BusinessRespCode {


    SUCCESS("0000", "业务处理成功"),
    BUSI_USER_ID_EXIST("1001", "用户ID不存在"),
    BUSI_EXCEPTION("9999", "系统异常");

    private String code;
    private String msg;

    BusinessRespCode(String code, String msg) {
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
