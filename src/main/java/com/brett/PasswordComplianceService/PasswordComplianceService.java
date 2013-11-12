package com.brett.PasswordComplianceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.LinkedList;
import java.util.List;

@Component
public class PasswordComplianceService {

    @Autowired
    MasterValidator parentValidator;

    public PasswordComplianceService(){


    }

    public boolean validatePassword(Password passwordToTest) {
        Errors errors = new BeanPropertyBindingResult(passwordToTest, "passwordToTest");

        parentValidator.validate(passwordToTest, errors);

        return !errors.hasErrors();
    }


}
