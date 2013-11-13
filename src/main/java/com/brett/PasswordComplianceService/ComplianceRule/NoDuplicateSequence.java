package com.brett.PasswordComplianceService.ComplianceRule;

import com.brett.PasswordComplianceService.Password;
import com.brett.PasswordComplianceService.utils.Utils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

public class NoDuplicateSequence extends PasswordComplianceRule {
    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "myPassword", "myPassword.empty");

        Password password = (Password) target;
        if (password.getMyPassword() != null){

            if (Utils.containsDuplicateSequence(password.getMyPassword())){
                errors.rejectValue("myPassword", "Duplicate character sequence detected");
            }
        }

    }
}
