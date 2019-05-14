package com.springmvc.entity.businessVO;

import com.springmvc.entity.sysVO.BaseBusinessRespVo;

/**
 * @ClassName userQuery
 * @Description data-实体信息
 * @Author xueruiye
 * @Date 2019/5/13
 * @Version 1.0
 **/
public class UsertQueryRespVo extends BaseBusinessRespVo {

    private Integer id;

    private String userName;

    private String password;

    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
