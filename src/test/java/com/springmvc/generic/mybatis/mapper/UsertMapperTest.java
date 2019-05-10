package com.springmvc.generic.mybatis.mapper;


import com.alibaba.fastjson.JSON;
import com.springmvc.generic.mybatis.pojo.Usert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/spring/applicationContext.xml"})
public class UsertMapperTest{


    @Autowired
    private UsertMapper usertMapper;

    @Test
    public void test(){
        Usert usert = usertMapper.selectByPrimaryKey(1);
        System.out.println(JSON.toJSONString(usert));
    }

}