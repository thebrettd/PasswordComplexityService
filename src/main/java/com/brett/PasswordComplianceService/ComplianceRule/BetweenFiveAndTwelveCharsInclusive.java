package com.brett.PasswordComplianceService.ComplianceRule;

import com.brett.PasswordComplianceService.Password;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

public class BetweenFiveAndTwelveCharsInclusive extends PasswordComplianceRule {

    public BetweenFiveAndTwelveCharsInclusive(){}

    /***
     * Password must be between 6 and 12 characters inclusive
     * @param target
     * @param errors
     */
    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "myPassword", "myPassword.empty");

        Password password = (Password) target;

        if (password.getMyPassword() != null){
            if (password.getMyPassword().length() < 5){
                errors.rejectValue("myPassword", "Password must be at least 6 characters long");
            }else if (password.getMyPassword().length() > 12){
                errors.rejectValue("myPassword", "Password cannot be longer than 12 characters");
            }
        }
    }
}
