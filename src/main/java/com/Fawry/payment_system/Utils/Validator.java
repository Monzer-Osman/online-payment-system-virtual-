package com.Fawry.payment_system.Utils;

import com.Fawry.payment_system.Exceptions.InvalidEmail;
import com.Fawry.payment_system.Exceptions.InvalidPassword;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class Validator{

    public void isEmailValid(String email) throws Exception{
        Pattern pattern = Pattern.compile(
                "[a-zA-Z\\_]+[a-zA-Z\\_0-9]*\\@[a-zA-Z\\_]{3,}\\.[a-zA-Z]{2,3}");
        Matcher matcher = pattern.matcher(email);
        boolean matchFound = matcher.matches();
        if(!matchFound) {
            throw new InvalidEmail("Invalid Email");
        }
    }

    public void isPasswordValid(String password) throws Exception {
        Pattern pattern = Pattern.compile("[a-zA-Z]{3,}[a-zA-Z0-9\\$\\@\\&]{2,}");
        Matcher matcher = pattern.matcher(password);
        boolean matchFound = matcher.matches();
        if (!matchFound) {
            throw new InvalidPassword("Invalid Password");
        }
    }

}
