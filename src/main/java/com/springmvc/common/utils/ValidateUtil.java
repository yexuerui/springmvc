package com.springmvc.common.utils;

import com.springmvc.common.enums.ResponseCodeEnum;
import com.springmvc.common.exception.ValidateException;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * @ClassName ValidateUtil
 * @Description Bean对象验证
 * @Author xueruiye
 * @Date 2019/5/13
 * @Version 1.0
 **/
public class ValidateUtil {


    private static Validator validator;

    static {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    public static <T> void validate(T t) throws ValidateException {
        if (null == t) {
            throw new ValidateException(ResponseCodeEnum.VALIDATE_PARAM_EMPTY.getRespCode(),
                    ResponseCodeEnum.VALIDATE_PARAM_EMPTY.getRespDesc());
        }
        ArrayList<String> errorList = new ArrayList<String>();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(t);
        for (ConstraintViolation<T> constraintViolation : constraintViolations) {
            errorList.add(constraintViolation.getMessage());
        }
        //List集合转化为特定规则的String
        if ((null != errorList) && !errorList.isEmpty()) {
            throw new ValidateException(ResponseCodeEnum.VALIDATE_PARAM_ILLEGAL.getRespCode(),
                    StringUtils.join(errorList, ","));
        }
    }
}
