package com.springmvc.common.exception;

/**
 * @ClassName ValidateException
 * @Description TODO
 * @Author xueruiye
 * @Date 2019/5/13
 * @Version 1.0
 **/
public class ValidateException extends RuntimeException {

    private String code;

    public ValidateException() {
        super();
    }

    public ValidateException(String message) {
        super(message);
    }

    public ValidateException(String code, String message) {
        super(message);
        this.code = code;
    }

    public ValidateException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidateException(Throwable cause) {
        super(cause);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
