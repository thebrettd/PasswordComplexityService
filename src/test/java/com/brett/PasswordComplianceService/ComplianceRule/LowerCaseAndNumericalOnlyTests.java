package com.brett.PasswordComplianceService.ComplianceRule;

import com.brett.PasswordComplianceService.Password;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import static org.junit.Assert.*;

public class LowerCaseAndNumericalOnlyTests {

    Password passwordToTest;
    LowerCaseAndNumericalOnly validator;
    Errors errors;

    @Before
    public void initialize(){
        passwordToTest = new Password();
        validator = new LowerCaseAndNumericalOnly();
        errors = new BeanPropertyBindingResult(passwordToTest, "passwordToTest");
    }

    private void validate() {
        validator.validate(passwordToTest, errors);
    }

    @Test
    public void testNullPasswordInvalid() throws Exception {

        validate();

        assertTrue(errors.hasErrors());
        assertNotNull(errors.getFieldError("myPassword"));
    }

    @Test
    public void testWhitespacePasswordInvalid() throws Exception {
        passwordToTest.setMyPassword(" ");
        validate();

        assertTrue(errors.hasErrors());
        assertNotNull(errors.getFieldError("myPassword"));
    }

    @Test
    public void testNoNumbersInvalid() throws Exception{
        validate();

        assertTrue(errors.hasErrors());
        assertNotNull(errors.getFieldError("myPassword"));
    }

    @Test
    public void testNoLowercaseLettersInvalid() throws Exception{
        passwordToTest.setMyPassword("123");
        validate();

        assertTrue(errors.hasErrors());
        assertNotNull(errors.getFieldError("myPassword"));
    }

    @Test
    public void testOnlyUppercaseInvalid() throws Exception{
        passwordToTest.setMyPassword("ABC123");
        validate();

        assertTrue(errors.hasErrors());
        assertNotNull(errors.getFieldError("myPassword"));
    }

    @Test
    public void testBasicValid() throws Exception{
        passwordToTest.setMyPassword("abc123");
        validate();

        assertFalse(errors.hasErrors());
        assertNull(errors.getFieldError("myPassword"));
    }

    @Test
    public void testCombinationInvalid() throws Exception{
        passwordToTest.setMyPassword("abcABC123");
        validate();

        assertTrue(errors.hasErrors());
        assertNotNull(errors.getFieldError("myPassword"));
    }
}
