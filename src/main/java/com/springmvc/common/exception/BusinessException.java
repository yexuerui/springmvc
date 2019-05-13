package com.springmvc.common.exception;

/**
 * @ClassName BusinessException
 * @Description 业务异常
 * @Author xueruiye
 * @Date 2019/5/13
 * @Version 1.0
 **/
public class BusinessException extends RuntimeException {

    //继承的顶级父类实现了序列化接口，子类还是需要显示的声明SerialVersionUID。
    private static final long serialVersionUID = -3516896655779527315L;
    /**
     * 保存用户错误码
     */
    private String code = "";

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }

    /**
     * 错误描述-原因
     *
     * @param message
     * @param cause
     */
    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }


    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String code, String message) {
        super(message); //调用父类的this.message=message;
        this.code = code;
    }

    public BusinessException(String code, String message, Throwable cause) {
        super(message, cause); //调用父类的构造方法，减少重复代码
        this.code = code;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
