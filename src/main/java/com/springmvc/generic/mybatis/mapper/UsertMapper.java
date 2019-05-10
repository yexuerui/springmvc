package com.springmvc.generic.mybatis.mapper;

import com.springmvc.generic.mybatis.pojo.Usert;
import com.springmvc.generic.mybatis.pojo.UsertExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsertMapper {
    long countByExample(UsertExample example);

    int deleteByExample(UsertExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Usert record);

    int insertSelective(Usert record);

    List<Usert> selectByExample(UsertExample example);

    Usert selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Usert record, @Param("example") UsertExample example);

    int updateByExample(@Param("record") Usert record, @Param("example") UsertExample example);

    int updateByPrimaryKeySelective(Usert record);

    int updateByPrimaryKey(Usert record);
}