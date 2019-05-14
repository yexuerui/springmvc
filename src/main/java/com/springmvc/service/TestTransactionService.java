package com.springmvc.service;

import com.springmvc.generic.mybatis.mapper.UsertMapper;
import com.springmvc.generic.mybatis.pojo.Usert;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @ClassName TestTransactionService
 * @Description 内部方法调用事务方法是否会回滚
 * @Author xueruiye
 * @Date 2019/5/14
 * @Version 1.0
 **/
@Service
public class TestTransactionService {

    @Resource
    private UsertMapper usertMapper;

    /**
     * 内部方法调用本类事务方法的关键，重新进行AOP增强
     */
    @Resource
    TestTransactionService testTransactionService;

    //业务逻辑方法
    public void businessUsert(Usert usert) {
        testTransactionService.insertUsert(usert);
    }

    @Transactional
    public void insertUsert(Usert usert) {
        usertMapper.insert(usert);
        throw new RuntimeException("抛出异常");
    }

}
