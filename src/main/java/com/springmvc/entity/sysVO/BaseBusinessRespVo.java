package com.springmvc.entity.sysVO;

/**
 * @ClassName BaseBusinessRespVo
 * @Description 响应体基类
 * @Author xueruiye
 * @Date 2019/5/13
 * @Version 1.0
 **/
public class BaseBusinessRespVo {
    private String subCode;
    private String subMsg;

    public String getSubCode() {
        return subCode;
    }

    public void setSubCode(String subCode) {
        this.subCode = subCode;
    }

    public String getSubMsg() {
        return subMsg;
    }

    public void setSubMsg(String subMsg) {
        this.subMsg = subMsg;
    }
}
