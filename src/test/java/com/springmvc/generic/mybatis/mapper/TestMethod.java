package com.springmvc.generic.mybatis.mapper;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * @ClassName TestMethod
 * @Description TODO
 * @Author xueruiye
 * @Date 2019/5/13
 * @Version 1.0
 **/
public class TestMethod {

    public static String idPassport(String id) {
        if (StringUtils.isEmpty(id) || (id.length() < 5)) {
            return id;
        }
        return id.substring(0, 2) + new String(new char[id.length() - 5]).replace("\0", "*") + id.substring(id.length() - 3);
    }

    @Test
    public void testIdPassport() {

        String idPassport = idPassport("123456789");
        System.out.println(idPassport);
    }
}
