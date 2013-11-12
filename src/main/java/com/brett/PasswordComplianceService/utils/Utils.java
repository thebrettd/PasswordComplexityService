package com.brett.PasswordComplianceService.utils;

import java.util.regex.Pattern;

public class Utils {

    private static final Pattern LOWER_CASE = Pattern.compile("[\\p{L}&&[^\\p{Lu}]]");
    private static final Pattern DECIMAL_DIGIT = Pattern.compile("\\p{Nd}");

    public static boolean containsDigit(String string){
        return DECIMAL_DIGIT.matcher(string).find();
    }

    public static boolean containsLowerCase(String string){
        return LOWER_CASE.matcher(string).find();
    }

}
