package com.brett.PasswordComplianceService;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class SpringAppTests {

    @Autowired
    private PasswordComplianceService passwordComplianceService;

    @Test
    public void testValidateSimplePassword() {
        Password password = new Password();
        password.setMyPassword("abc123");
        Assert.assertEquals(true, passwordComplianceService.validatePassword(password));

        password.setMyPassword("short");
        Assert.assertEquals(false, passwordComplianceService.validatePassword(password));

        password.setMyPassword("abc123ABC");
        Assert.assertEquals(false, passwordComplianceService.validatePassword(password));

    }
}
