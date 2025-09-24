package edu.ccrm.util;

public class Validator {
    public static boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }
    public static boolean isNonEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }
}
