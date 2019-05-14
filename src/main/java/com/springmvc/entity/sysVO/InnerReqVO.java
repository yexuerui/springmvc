package com.springmvc.entity.sysVO;

import com.alibaba.fastjson.JSON;
import com.springmvc.entity.businessVO.UsertQueryReqVo;

/**
 * @ClassName InnerReqDTO
 * @Description 公共请求头
 * @Author xueruiye
 * @Date 2019/5/13
 * @Version 1.0
 **/
public class InnerReqVO {

    //版本号
    private String versionNo;

    private String data; // 业务请求参数（JSON格式字符串）

    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public static void main(String[] args) {
        InnerReqVO innerReqVO = new InnerReqVO();
        innerReqVO.setVersionNo("1.0");
        UsertQueryReqVo usertQueryReqVo = new UsertQueryReqVo();
        usertQueryReqVo.setId(2);
        innerReqVO.setData(JSON.toJSONString(usertQueryReqVo));

        String string = JSON.toJSONString(innerReqVO);
        System.out.println(string);
    }
}
