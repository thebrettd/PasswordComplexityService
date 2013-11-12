package com.brett.PasswordComplianceService.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class UtilsTests {

    @Test
    public void testContainsDigit() throws Exception {

        assertTrue(Utils.containsDigit("1"));
        assertTrue(Utils.containsDigit("123"));
        assertFalse(Utils.containsDigit("A"));
        assertFalse(Utils.containsDigit("ABC"));

        assertTrue(Utils.containsDigit("ABC1"));

        assertTrue(Utils.containsDigit("ABC1ABC"));
    }



    @Test
    public void testContainsLowerCase() throws Exception {
        assertTrue(Utils.containsLowerCase("a"));
        assertTrue(Utils.containsLowerCase("abc"));

        assertFalse(Utils.containsLowerCase("A"));
        assertFalse(Utils.containsLowerCase("ABC"));

        assertTrue(Utils.containsLowerCase("abc123"));
        assertTrue(Utils.containsLowerCase("Abc123"));
    }


}
