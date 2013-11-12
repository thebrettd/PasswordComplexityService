package com.brett.PasswordComplianceService;

import org.springframework.validation.Validator;

import java.util.List;

public class MasterValidator {

    private List<Validator> validators;

    public MasterValidator(){

    }

    public List<Validator> getValidators() {
        return validators;
    }

    public void setValidators(List<Validator> validators) {
        this.validators = validators;
    }
}
