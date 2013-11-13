package com.brett.PasswordComplianceService.ComplianceRule;

import com.brett.PasswordComplianceService.Password;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

public class NoDuplicateSequence extends PasswordComplianceRule {
    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "myPassword", "myPassword.empty");

        Password password = (Password) target;
        if (password.getMyPassword() != null){

        }

    }
}
