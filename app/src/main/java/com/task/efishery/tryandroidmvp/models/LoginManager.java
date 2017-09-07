package com.task.efishery.tryandroidmvp.models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by syauqi on 07/09/17.
 */

public class LoginManager {
    private static LoginManager sInstance;

    public static LoginManager getInstance(){
        if(sInstance==null){
            sInstance = new LoginManager();
        }
        return sInstance;
    }

    public boolean validate(String email,String password){
        return isValidEmail(email) & isPasswordCorrect(password);
    }

    private boolean isValidEmail(String email){
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isPasswordCorrect(String password){
        return password.equalsIgnoreCase("123");
    }

}
