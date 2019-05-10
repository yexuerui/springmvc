package com.springmvc.entity;

import java.util.List;

/**
 * @ClassName UserPO
 * @Description TODO
 * @Author xueruiye
 * @Date 2019/5/6
 * @Version 1.0
 **/
public class UserPO {
    private String id;
    private String name;
    private Integer age;
    private String sex;
    private List<String> sports;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<String> getSports() {
        return sports;
    }

    public void setSports(List<String> sports) {
        this.sports = sports;
    }

    @Override
    public String toString() {
        return "UserPO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", sports=" + sports +
                '}';
    }
}
