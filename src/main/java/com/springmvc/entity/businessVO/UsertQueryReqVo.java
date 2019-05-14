package com.springmvc.entity.businessVO;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @ClassName UsertQueryReqVo
 * @Description TODO
 * @Author xueruiye
 * @Date 2019/5/13
 * @Version 1.0
 **/
public class UsertQueryReqVo {

    //javax.validation.UnexpectedTypeException: No validator could be found for type: java.lang.Integer

    @NotNull(message = "参数[id]不能为空")
//    @Pattern(regexp = "[1-9]+[0-9]{1,9}", message = "id必须是数字格式")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
