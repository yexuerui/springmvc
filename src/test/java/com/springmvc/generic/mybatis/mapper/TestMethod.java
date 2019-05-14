package com.springmvc.generic.mybatis.mapper;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName TestMethod
 * @Description TODO
 * @Author xueruiye
 * @Date 2019/5/13
 * @Version 1.0
 **/
public class TestMethod {

    /**
     * 证件脱敏
     * @param id
     * @return
     */
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

    @Test
    public void testReplace() {
        char[] charArr = new char[3];
        if (charArr != null) {
            for (char c : charArr) {
                System.out.println("打印的值：" + c);
            }
        }
    }

    @Test
    public void testPattern() {
        String line = new String(new char[1]);
        int length = line.length();
        String pattern = "\0";
//        String pattern = "^$";
        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher(line);
        System.out.println(matcher.find());
    }

    @Test
    public void testStringFormat(){
        String format = String.format("首先说%10.2f", 10000.2345);
    }

    @Test
    public void testDecimalFormat(){
        //如果是数字，将其格式化
        DecimalFormat decimalFormat=new DecimalFormat("0.00");
        String format = decimalFormat.format(1);

        DecimalFormat decimalFormat1=new DecimalFormat("#.##");
        String format1 = decimalFormat1.format(1);
    }

}
