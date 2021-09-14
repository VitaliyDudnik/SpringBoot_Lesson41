package com.tms;

public interface Constants {
    String USER_GET_BY_USERNAME = "from User where username = :username";
    String USER_GET_BY_PASS = "from User where password = :password";
    String CALC_GET_ALL_OPERATIONS = "from Operation";
    String REGEX_PASSWORD = "(?=.*[0-9])(?=\\S+$).{5,20}";
    String REGEX_USERNAME = "(?=\\S+$).{5,20}";
    String ATTRIBUTE_EXISTS_USERNAME_PASS = "Username or Password is incorrect";
}
