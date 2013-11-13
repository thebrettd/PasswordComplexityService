package com.brett.PasswordComplianceService.ComplianceRule;

import com.brett.PasswordComplianceService.Password;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import static org.junit.Assert.*;

public class NoDuplicateSequenceTests {

    Password passwordToTest;
    NoDuplicateSequence validator;
    Errors errors;

    @Before
    public void initialize(){
        passwordToTest = new Password();
        validator = new NoDuplicateSequence();
        errors = new BeanPropertyBindingResult(passwordToTest, "passwordToTest");
    }

    @Test
    public void testNoDupesValid(){
        passwordToTest.setMyPassword("123");
        validateAndAssertNoErrors();

        passwordToTest.setMyPassword("testing123");
        validateAndAssertNoErrors();

        passwordToTest.setMyPassword("1234");
        validateAndAssertNoErrors();


        passwordToTest.setMyPassword("abcd1234");
        validateAndAssertNoErrors();

    }

    private void validateAndAssertNoErrors() {
        validate();
        assertFalse(errors.hasErrors());
        assertNull(errors.getFieldError("myPassword"));
    }

    private void validate() {
        validator.validate(passwordToTest,errors);
    }

    @Test
    public void testDupeWordInvalid(){
        passwordToTest.setMyPassword("blahblah1");
        validAndAssertError();

        passwordToTest.setMyPassword("blah1blah1");
        validAndAssertError();

        passwordToTest.setMyPassword("abab");
        validAndAssertError();

        passwordToTest.setMyPassword("swimmingpool1");
        validAndAssertError();

        passwordToTest.setMyPassword("aab");
        validAndAssertError();

        passwordToTest.setMyPassword("abab");
        validAndAssertError();
    }

    private void validAndAssertError() {
        validate();
        assertTrue(errors.hasErrors());
        assertNotNull(errors.getFieldError("myPassword"));
    }


}
