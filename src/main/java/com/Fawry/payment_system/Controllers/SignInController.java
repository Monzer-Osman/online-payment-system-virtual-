package com.Fawry.payment_system.Controllers;

import com.Fawry.payment_system.Models.User;
import com.Fawry.payment_system.Records.SignInRecord;
import com.Fawry.payment_system.Services.SignInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Fawry_System/user")
public class SignInController {
    private SignInService signInService;

    @Autowired
    public SignInController(SignInService signInService){
        this.signInService = signInService;
    }

    @PostMapping("/login")
    public String login(@RequestBody SignInRecord loginData){
        try {
            User user = signInService.loginProcess(loginData.email(), loginData.password());
        }catch (Exception e){
            System.out.println(e.getMessage());
            return e.getMessage();
        }
        return "login successfully";
    }
}
