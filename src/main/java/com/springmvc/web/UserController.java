package com.springmvc.web;

import com.alibaba.fastjson.JSON;
import com.springmvc.common.enums.ResponseCodeEnum;
import com.springmvc.common.exception.BusinessException;
import com.springmvc.common.exception.ValidateException;
import com.springmvc.common.utils.ValidateUtil;
import com.springmvc.entity.sysVO.BaseBusinessRespVo;
import com.springmvc.entity.sysVO.InnerReqVO;
import com.springmvc.entity.sysVO.InnerRespVO;
import com.springmvc.generic.mybatis.pojo.Usert;
import com.springmvc.service.UsertService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.RequestBody;
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

    /**
     * 传输VO对象给前端
     *
     * @return
     */

    @RequestMapping(value = "/userInfo", method = RequestMethod.POST)
    @ResponseBody
    public InnerRespVO queryUserInfo(InnerReqVO innerReqVO) {
        String data = innerReqVO.getData();
        InnerRespVO innerRespVO = new InnerRespVO();
        BaseBusinessRespVo baseBusinessRespVo = new BaseBusinessRespVo();
        //将json对象转化成对象
        try {
            Usert usert = JSON.parseObject(data, Usert.class);
            //参数校验
            ValidateUtil.validate(usert);
            //业务处理
            innerRespVO = usertService.userInfoQuery(usert);
        } catch (ValidateException e) {
            baseBusinessRespVo.setSubCode(e.getCode());
            baseBusinessRespVo.setSubMsg(e.getMessage());
        } catch (BusinessException e) {
            //业务异常
            baseBusinessRespVo.setSubCode(ResponseCodeEnum.BUSINESS_EXCEPTION.getRespCode());
            baseBusinessRespVo.setSubMsg(e.getMessage());
        } catch (Exception e) {
            baseBusinessRespVo.setSubCode(ResponseCodeEnum.EXCRPTION.getRespCode());
            baseBusinessRespVo.setSubMsg(ResponseCodeEnum.EXCRPTION.getRespDesc());
        } finally {
            innerRespVO.setCode(ResponseCodeEnum.SUCCESS.getRespCode());
            innerRespVO.setMsg(ResponseCodeEnum.SUCCESS.getRespDesc());
            innerRespVO.setData(JSON.toJSONString(baseBusinessRespVo));
        }
        return innerRespVO;
    }


}
