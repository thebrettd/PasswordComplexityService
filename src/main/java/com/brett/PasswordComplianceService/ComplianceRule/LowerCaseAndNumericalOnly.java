package com.brett.PasswordComplianceService.ComplianceRule;

import com.brett.PasswordComplianceService.Password;
import com.brett.PasswordComplianceService.utils.Utils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class LowerCaseAndNumericalOnly implements Validator {

    public LowerCaseAndNumericalOnly(){}

    @Override
    public boolean supports(Class<?> clazz) {
        return Password.class.equals(clazz);
    }

    /***
     * Must consist of a mixture of lowercase letters and numerical digits only, with at least one of each.
     * @param target
     * @param errors
     */
    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "myPassword", "myPassword.empty");

        Password password = (Password) target;

        if (password.getMyPassword() != null){

            // [a-z] a through z lowercase
            // //d a digit 0-9
            // ([a-z]|[\\d]])*

            if (! (Utils.containsDigit(password.getMyPassword()) && Utils.containsLowerCase(password.getMyPassword()) ) ){
                errors.rejectValue("myPassword", "Password must contain at least one letter and at least one digit");
            }

            //todo
            //must contain ONLY digit and lowercase

        }


    }

}