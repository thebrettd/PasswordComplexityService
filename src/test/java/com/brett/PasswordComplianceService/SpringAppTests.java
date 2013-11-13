package com.brett.PasswordComplianceService;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.validation.Errors;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:password-servlet.xml")
public class SpringAppTests {

    @Autowired
    private PasswordComplianceService passwordComplianceService;

    @Test
    public void testAll() {
        Password password = new Password();
        password.setMyPassword("abc123");
        Errors errors = passwordComplianceService.validatePassword(password);
        Assert.assertFalse(errors.hasErrors());

        password.setMyPassword("short");
        errors = passwordComplianceService.validatePassword(password);
        Assert.assertTrue(errors.hasErrors());

        password.setMyPassword("abc123ABC");
        errors = passwordComplianceService.validatePassword(password);
        Assert.assertTrue(errors.hasErrors());

        password.setMyPassword("abcabc1");
        errors = passwordComplianceService.validatePassword(password);
        Assert.assertTrue(errors.hasErrors());

    }
}
