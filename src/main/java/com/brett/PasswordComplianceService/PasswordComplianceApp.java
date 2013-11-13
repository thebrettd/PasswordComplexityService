package com.brett.PasswordComplianceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/validate")
public class PasswordComplianceApp {

    @Autowired
    private PasswordComplianceService myService;

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody String validatePassword(@RequestBody String password)
    {
        Password passwordToValidate = new Password(password);

        Errors e = validatePassword(passwordToValidate);
        return generateResponseBody(e);
    }

    private String generateResponseBody(Errors e) {
        if(!e.hasErrors()){
            return "The provided password is valid!";
        }else{
            return "The specified password is invalid: " + e.getAllErrors();
        }
    }

    private Errors validatePassword(Password passwordToValidate) {
        return myService.validatePassword(passwordToValidate);
    }

}
