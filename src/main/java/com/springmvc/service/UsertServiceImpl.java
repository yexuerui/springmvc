package com.springmvc.service;

import com.springmvc.generic.mybatis.mapper.UsertMapper;
import com.springmvc.generic.mybatis.pojo.Usert;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @ClassName UsertServiceImpl
 * @Description TODO
 * @Author xueruiye
 * @Date 2019/5/10
 * @Version 1.0
 **/
@Service
public class UsertServiceImpl implements UsertService {

    @Resource
    private UsertMapper usertMapper;

    public Usert getUserById(Integer id) {
        return usertMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public int insertUser(Usert usert) {
        int insert = 0;
        try {
            insert = usertMapper.insert(usert);
        } catch (Exception e) {
            throw new RuntimeException("出现异常");
        }
        return insert;
    }
}
