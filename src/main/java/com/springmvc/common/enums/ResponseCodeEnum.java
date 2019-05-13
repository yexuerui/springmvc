package com.springmvc.common.enums;

/**
 * @ClassName ResponseCodeEnum
 * @Description 公共响应报文体
 * @Author xueruiye
 * @Date 2019/5/13
 * @Version 1.0
 **/
public enum ResponseCodeEnum {

    VALIDATE_PARAM_EMPTY("E001", "请求参数为空"),
    VALIDATE_PARAM_ILLEGAL("E002", "请求参数非法"),

    SUCCESS("0000", "请求成功"),
    BUSINESS_EXCEPTION("9990", "业务处理异常"),
    EXCRPTION("9999", "系统异常");


    private String respCode;
    private String respDesc;

    ResponseCodeEnum(String respCode, String respDesc) {
        this.respCode = respCode;
        this.respDesc = respDesc;
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespDesc() {
        return respDesc;
    }

    public void setRespDesc(String respDesc) {
        this.respDesc = respDesc;
    }}
