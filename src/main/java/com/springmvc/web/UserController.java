package com.springmvc.web;

import com.alibaba.fastjson.JSON;
import com.springmvc.generic.mybatis.mapper.UsertMapper;
import com.springmvc.generic.mybatis.pojo.Usert;
import com.springmvc.service.UsertService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author xueruiye
 * @Date 2019/5/10
 * @Version 1.0
 **/
@Controller
public class UserController {

    @Resource
    private UsertService usertService;

    @ResponseBody
//    @RequestMapping(value = "user",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    @RequestMapping(value = "user", method = RequestMethod.GET)
    public String showUserName() {
        Usert usert = new Usert();
        usert.setId(2);
        usert.setAge(20);
        usert.setUserName("李明");
        usert.setPassword("123");
        int i = usertService.insertUser(usert);
        return "xxx";
//        return "成功";
//        return "success";
    }


}
