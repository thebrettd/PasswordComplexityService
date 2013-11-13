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

        assertFalse(errors.hasErrors());
        assertNull(errors.getFieldError("myPassword"));
    }

    //todo
    //@Test
    public void testDupeWordInvalid(){
        passwordToTest.setMyPassword("blahblah1");

        assertTrue(errors.hasErrors());
        assertNotNull(errors.getFieldError("myPassword"));
    }



}
