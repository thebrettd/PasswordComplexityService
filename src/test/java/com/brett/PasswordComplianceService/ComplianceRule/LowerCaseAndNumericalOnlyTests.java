package com.brett.PasswordComplianceService.ComplianceRule;

import com.brett.PasswordComplianceService.Password;
import org.junit.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import static org.junit.Assert.*;

public class LowerCaseAndNumericalOnlyTests {

    @Test
    public void testNullPasswordInvalid() throws Exception {
        Password passwordToTest = new Password();

        LowerCaseAndNumericalOnly validator = new LowerCaseAndNumericalOnly();

        Errors errors = new BeanPropertyBindingResult(passwordToTest, "passwordToTest");
        validator.validate(passwordToTest, errors);

        assertTrue(errors.hasErrors());
        assertNotNull(errors.getFieldError("myPassword"));
    }

    @Test
    public void testWhitespacePasswordInvalid() throws Exception {
        Password passwordToTest = new Password();
        passwordToTest.setMyPassword(" ");

        LowerCaseAndNumericalOnly validator = new LowerCaseAndNumericalOnly();

        Errors errors = new BeanPropertyBindingResult(passwordToTest, "passwordToTest");
        validator.validate(passwordToTest, errors);

        assertTrue(errors.hasErrors());
        assertNotNull(errors.getFieldError("myPassword"));
    }

    @Test
    public void testNoNumbersInvalid() throws Exception{
        Password passwordToTest = new Password();
        passwordToTest.setMyPassword("abc");
        LowerCaseAndNumericalOnly validator = new LowerCaseAndNumericalOnly();

        Errors errors = new BeanPropertyBindingResult(passwordToTest, "passwordToTest");
        validator.validate(passwordToTest, errors);

        assertTrue(errors.hasErrors());
        assertNotNull(errors.getFieldError("myPassword"));
    }

    @Test
    public void testNoLowercaseLettersInvalid() throws Exception{
        Password passwordToTest = new Password();
        passwordToTest.setMyPassword("123");
        LowerCaseAndNumericalOnly validator = new LowerCaseAndNumericalOnly();

        Errors errors = new BeanPropertyBindingResult(passwordToTest, "passwordToTest");
        validator.validate(passwordToTest, errors);

        assertTrue(errors.hasErrors());
        assertNotNull(errors.getFieldError("myPassword"));
    }

    @Test
    public void testOnlyUppercaseInvalid() throws Exception{
        Password passwordToTest = new Password();
        passwordToTest.setMyPassword("ABC123");
        LowerCaseAndNumericalOnly validator = new LowerCaseAndNumericalOnly();

        Errors errors = new BeanPropertyBindingResult(passwordToTest, "passwordToTest");
        validator.validate(passwordToTest, errors);

        assertTrue(errors.hasErrors());
        assertNotNull(errors.getFieldError("myPassword"));
    }

    @Test
    public void testBasicValid() throws Exception{
        Password passwordToTest = new Password();
        passwordToTest.setMyPassword("abc123");
        LowerCaseAndNumericalOnly validator = new LowerCaseAndNumericalOnly();

        Errors errors = new BeanPropertyBindingResult(passwordToTest, "passwordToTest");
        validator.validate(passwordToTest, errors);

        assertFalse(errors.hasErrors());
        assertNull(errors.getFieldError("myPassword"));
    }

    @Test
    public void testCombinationInvalid() throws Exception{
        Password passwordToTest = new Password();
        passwordToTest.setMyPassword("abcABC123");
        LowerCaseAndNumericalOnly validator = new LowerCaseAndNumericalOnly();

        Errors errors = new BeanPropertyBindingResult(passwordToTest, "passwordToTest");
        validator.validate(passwordToTest, errors);

        assertTrue(errors.hasErrors());
        assertNotNull(errors.getFieldError("myPassword"));
    }




}
