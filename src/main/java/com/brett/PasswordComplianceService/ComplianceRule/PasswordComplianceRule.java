package com.brett.PasswordComplianceService.ComplianceRule;

import com.brett.PasswordComplianceService.Password;
import org.springframework.validation.Validator;

public abstract class PasswordComplianceRule implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Password.class.equals(clazz);
    }

}
