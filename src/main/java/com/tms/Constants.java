package com.tms;

public interface Constants {
    String REGEX_PASSWORD = "(?=.*[0-9])(?=\\S+$).{5,20}";
    String REGEX_USERNAME = "(?=\\S+$).{5,20}";
    String ATTRIBUTE_EXISTS_USERNAME_PASS = "Username or Password is incorrect";
}
