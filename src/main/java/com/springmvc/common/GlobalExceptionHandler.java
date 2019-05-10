package com.springmvc.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName GlobalExceptionHandler
 * @Description TODO
 * @Author xueruiye
 * @Date 2019/5/10
 * @Version 1.0
 **/
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map<String,Object> exception(Exception e){
        logger.info("全局捕获异常日志打印...");
        Map<String,Object> map=new HashMap<String, Object>();
        System.out.println("================全局捕获异常=================");
        e.printStackTrace();
        map.put("info","error");
        return map;
    }

}
