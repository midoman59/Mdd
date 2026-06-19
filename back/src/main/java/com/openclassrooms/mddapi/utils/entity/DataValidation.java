package com.openclassrooms.mddapi.utils.entity;

import java.util.regex.Pattern;

public class DataValidation {

  private static final String EMAIL_PATTERN =
      "^[A-Za-z0-9+_.-]+@(.+)$";

  private static final Pattern emailPattern = Pattern.compile(EMAIL_PATTERN);

  public static boolean isValidEmail(String email) {
    return email != null && emailPattern.matcher(email).matches();
  }

  public static boolean isValidUsername(String username) {
    return username != null && username.length() >= 3 && username.length() <= 50;
  }

  public static boolean isValidPassword(String password) {
    return password != null && password.length() >= 8;
  }
}
