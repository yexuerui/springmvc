package com.springmvc.web;

import junit.framework.TestCase;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/applicationContext.xml"})
public class UserControllerTest extends Object {

    public void testShowUserName() {
    }

    public void testQueryUserInfo() {
    }
}