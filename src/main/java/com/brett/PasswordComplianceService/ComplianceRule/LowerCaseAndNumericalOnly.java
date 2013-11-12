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

        String passwordString = password.getMyPassword();
        if (passwordString != null){

            boolean charFound = false;
            boolean digitFound = false;
            boolean invalidCharFound = false;

            for (int i=0;i< passwordString.length();i++){
                boolean currCharValid = false;
                boolean currDigitValid = false;
                char c = passwordString.charAt(i);

                if (Utils.validChar(c)){
                    charFound = true;
                    currCharValid = true;
                }
                else if (Utils.validDigit(c)){
                    digitFound = true;
                    currDigitValid = true;
                }

                if(!currCharValid && !currDigitValid){
                    invalidCharFound = true;
                }
            }


            if (!charFound){
                errors.rejectValue("myPassword", "Password must contain at least one lowercase letter");
            }
            if (!digitFound){
                errors.rejectValue("myPassword", "Password must contain at least one digit");
            }
            if (invalidCharFound){
                errors.rejectValue("myPassword", "Password may only contain lowercase letters and digits");
            }
        }


    }

}