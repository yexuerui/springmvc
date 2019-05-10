package com.springmvc.entity;

import java.util.List;

/**
 * @ClassName UserVO
 * @Description TODO
 * @Author xueruiye
 * @Date 2019/5/6
 * @Version 1.0
 **/
public class UserVO {
    private String name;
    private List<String> sports;
    private String name1;

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSports() {
        return sports;
    }

    public void setSports(List<String> sports) {
        this.sports = sports;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "name='" + name + '\'' +
                ", sports=" + sports +
                ", name1='" + name1 + '\'' +
                '}';
    }
}
