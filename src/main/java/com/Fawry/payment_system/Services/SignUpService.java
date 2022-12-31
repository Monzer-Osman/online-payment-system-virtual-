package com.Fawry.payment_system.Services;

import com.Fawry.payment_system.Models.User;
import com.Fawry.payment_system.Models.Wallet;
import com.Fawry.payment_system.Records.SignupRecord;
import com.Fawry.payment_system.Repositories.UserRepository;
import com.Fawry.payment_system.Repositories.WalletRepository;
import com.Fawry.payment_system.Utils.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {
    private UserRepository userRepository;
    private WalletRepository walletRepository;
    private Validator validator;

    @Autowired
    SignUpService(UserRepository userRepository, WalletRepository walletRepository, Validator validator){
        this.userRepository = userRepository;
        this.walletRepository = walletRepository;
        this.validator = validator;
    }

    public String signupProcess(SignupRecord userData) throws Exception {
        try {
            validator.isEmailValid(userData.email());
            validator.isPasswordValid(userData.password());
            if (!userExist(userData.email())) {
                Wallet wallet = new Wallet();
                User user = new User(userData.email(), userData.userName(), userData.password());
                walletRepository.save(wallet);
                userRepository.save(user);
            }
        }catch (Exception e){
            return e.getMessage();
        }
        return "Sign up Successfully";
    }

    public boolean userExist(String email){
        return userRepository.findByEmail(email) == null;
    }

}
