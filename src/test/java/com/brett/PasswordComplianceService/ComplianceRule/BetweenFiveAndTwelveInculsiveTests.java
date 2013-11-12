package com.brett.PasswordComplianceService.ComplianceRule;

import com.brett.PasswordComplianceService.Password;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import static org.junit.Assert.*;

public class BetweenFiveAndTwelveInculsiveTests {

    Password passwordToTest;
    BetweenFiveAndTwelveCharsInclusive validator;
    Errors errors;

    @Before
    public void initialize(){
        passwordToTest = new Password();
        validator = new BetweenFiveAndTwelveCharsInclusive();
        errors = new BeanPropertyBindingResult(passwordToTest, "passwordToTest");
    }

    @Test
    public void testTooShort() throws Exception {
        //testNull
        validator.validate(passwordToTest, errors);
        assertTrue(errors.hasErrors());
        assertNotNull(errors.getFieldError("myPassword"));

        //empty string
        passwordToTest.setMyPassword("");
        validator.validate(passwordToTest, errors);
        assertTrue(errors.hasErrors());
        assertNotNull(errors.getFieldError("myPassword"));

        passwordToTest.setMyPassword("1234");
        validator.validate(passwordToTest, errors);
        assertTrue(errors.hasErrors());
        assertNotNull(errors.getFieldError("myPassword"));
    }

    @Test
    public void testValid() throws Exception {
        passwordToTest.setMyPassword("12345");
        validator.validate(passwordToTest, errors);
        assertFalse(errors.hasErrors());

        passwordToTest.setMyPassword("123456789012");
        validator.validate(passwordToTest, errors);
        assertFalse(errors.hasErrors());
    }

    @Test
    public void testTooLong() throws Exception {
        passwordToTest.setMyPassword("1234567890123");
        validator.validate(passwordToTest, errors);
        assertTrue(errors.hasErrors());
        assertNotNull(errors.getFieldError("myPassword"));

    }

}
