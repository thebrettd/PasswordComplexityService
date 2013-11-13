package com.brett.PasswordComplianceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
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

        boolean b = validatePassword(passwordToValidate);
        return generateResponseBody(b);
    }

    private String generateResponseBody(boolean b) {
        if(b){
            return "The provided password is valid!";
        }else{
            return "The specified password is invalid :(";
        }
    }

    private boolean validatePassword(Password passwordToValidate) {
        return myService.validatePassword(passwordToValidate);
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/password-servlet.xml");
        PasswordComplianceService passwordComplianceService = context.getBean(PasswordComplianceService.class);
        Password password = new Password();
        password.setMyPassword("abc123");
        System.out.println(passwordComplianceService.validatePassword(password));
    }

}
