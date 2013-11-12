package com.brett.PasswordComplianceService;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

public class MasterValidator implements Validator {

    private List<Validator> validators;

    public MasterValidator(){}

    public List<Validator> getValidators() {
        return validators;
    }

    public void setValidators(List<Validator> validators) {
        this.validators = validators;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Password.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        for(Validator validator : validators){
            validator.validate(target,errors);
        }
    }

}
