package com.brett.PasswordComplianceService.ComplianceRule;

import com.brett.PasswordComplianceService.Password;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class BetweenFiveAndTwelveChars extends PasswordComplianceRule {

    public BetweenFiveAndTwelveChars(){}

    /***
     * Password must be between 5 and 12 characters exclusive
     * @param target
     * @param errors
     */
    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "myPassword", "myPassword.empty");

        Password password = (Password) target;

        if (password.getMyPassword() != null){
            if (password.getMyPassword().length() < 6){
                errors.rejectValue("myPassword", "Password must be greater than 5 characters long");
            }else if (password.getMyPassword().length() > 11){
                errors.rejectValue("myPassword", "Password cannot be longer than 11 characters");
            }
        }
    }
}
