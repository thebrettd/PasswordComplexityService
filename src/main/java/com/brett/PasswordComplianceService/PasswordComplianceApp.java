package com.brett.PasswordComplianceService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PasswordComplianceApp {



    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        PasswordComplianceService passwordComplianceService = context.getBean(PasswordComplianceService.class);
        Password password = new Password();
        password.setMyPassword("abc123");
        System.out.println(passwordComplianceService.validatePassword(password));
    }

}
