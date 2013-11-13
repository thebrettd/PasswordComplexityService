package com.brett.PasswordComplianceService;

public class Password {

    private String myPassword;

    public Password(){}

    public Password(String password){
        myPassword = password;
    }

    public String getMyPassword() {
        return myPassword;
    }

    public void setMyPassword(String myPassword) {
        this.myPassword = myPassword;
    }
}
