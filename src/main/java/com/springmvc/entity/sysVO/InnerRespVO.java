package com.springmvc.entity.sysVO;

/**
 * @ClassName InnerRespDTO
 * @Description 公共响应头
 * @Author xueruiye
 * @Date 2019/5/13
 * @Version 1.0
 **/
public class InnerRespVO {

    private String code;
    private String msg;
    private String timestamp;
    //JSON串，请求实体
    private String data;

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

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
