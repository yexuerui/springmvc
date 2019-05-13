package com.springmvc.service;

import com.alibaba.fastjson.JSON;
import com.springmvc.common.enums.BusinessRespCode;
import com.springmvc.common.enums.ResponseCodeEnum;
import com.springmvc.common.exception.BusinessException;
import com.springmvc.entity.businessVO.UsertQueryRespVo;
import com.springmvc.entity.sysVO.BaseBusinessRespVo;
import com.springmvc.entity.sysVO.InnerRespVO;
import com.springmvc.generic.mybatis.mapper.UsertMapper;
import com.springmvc.generic.mybatis.pojo.Usert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
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

    Logger logger = LoggerFactory.getLogger(UsertServiceImpl.class);

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

    //业务逻辑
    public InnerRespVO userInfoQuery(Usert usertVO) {
        InnerRespVO innerRespVO = new InnerRespVO();
        UsertQueryRespVo usertQueryRespVo = new UsertQueryRespVo();
        //查询本地库数据是否存在
        Usert usert = usertMapper.selectByPrimaryKey(usertVO.getId());
        if (usert == null) {
            logger.error("用户Id不存在");
            //抛出异常，保存错误码和错误信息（业务错误码）
            throw new BusinessException(BusinessRespCode.BUSI_USER_ID_EXIST.getCode(), BusinessRespCode.BUSI_USER_ID_EXIST.getMsg());
        }
        //将copyProperties(A,B);将A的值copy到B中
        BeanUtils.copyProperties(usert, usertQueryRespVo);
        //打印一下B的值
        usertQueryRespVo.setSubCode(ResponseCodeEnum.SUCCESS.getRespCode());
        usertQueryRespVo.setSubMsg(ResponseCodeEnum.SUCCESS.getRespDesc());
        String data = JSON.toJSONString(usertQueryRespVo);
        logger.info("查询对象B的值为[{}]", data);
        innerRespVO.setData(data);
        innerRespVO.setCode(ResponseCodeEnum.SUCCESS.getRespCode());
        innerRespVO.setMsg(ResponseCodeEnum.SUCCESS.getRespDesc());

        return innerRespVO;
    }

}
