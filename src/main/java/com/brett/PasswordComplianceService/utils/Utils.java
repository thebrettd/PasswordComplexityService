package com.brett.PasswordComplianceService.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    private static final Pattern LOWER_CASE = Pattern.compile("[\\p{L}&&[^\\p{Lu}]]");
    private static final Pattern DECIMAL_DIGIT = Pattern.compile("\\p{Digit}");


    public static boolean containsDigit(String string){
        return DECIMAL_DIGIT.matcher(string).find();
    }

    public static boolean containsLowerCase(String string){
        return LOWER_CASE.matcher(string).find();
    }

    public static boolean validChar(char c) {
        Matcher m = LOWER_CASE.matcher(Character.toString(c));
        return m.matches();
    }

    public static boolean validDigit(char c) {
        Matcher m = DECIMAL_DIGIT.matcher(Character.toString(c));
        return m.matches();
    }
}
