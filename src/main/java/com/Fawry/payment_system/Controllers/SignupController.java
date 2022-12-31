package com.Fawry.payment_system.Controllers;

import com.Fawry.payment_system.Models.User;
import com.Fawry.payment_system.Records.SignupRecord;
import com.Fawry.payment_system.Services.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Fawry_System/user")
public class SignupController {
    private SignUpService signUpService;

    @Autowired
    public SignupController(SignUpService signUpService){
        this.signUpService = signUpService;
    }

    @PostMapping("/signup")
    public String signup(@RequestBody SignupRecord signupData){
        try {
            signUpService.signupProcess(signupData);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return e.getMessage();
        }
        return "signup successfully";
    }

    @GetMapping("user/check")
    public boolean userCheck(String email){
        return signUpService.userExist(email);
    }

}
