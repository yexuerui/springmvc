package com.springmvc.service;

import com.springmvc.entity.businessVO.UsertQueryReqVo;
import com.springmvc.entity.sysVO.InnerRespVO;
import com.springmvc.generic.mybatis.pojo.Usert;

//接口层
public interface UsertService {

    /**
     * 根据Id查询用户信息
     *
     * @param id
     * @return
     */
    Usert getUserById(Integer id);

    /**
     * 插入数据
     *
     * @param usert
     * @return
     */
    int insertUser(Usert usert);

    /**
     * 根据usertVo查询用户信息
     *
     * @param usertVO
     * @return
     */
    InnerRespVO userInfoQuery(UsertQueryReqVo usertVO);

}
