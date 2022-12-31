package com.Fawry.payment_system.Services;
import com.Fawry.payment_system.Exceptions.EmailNotFoundException;
import com.Fawry.payment_system.Exceptions.WrongPasswordException;
import com.Fawry.payment_system.Models.User;
import com.Fawry.payment_system.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignInService {
    UserRepository userRepository;

    @Autowired
    public SignInService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User loginProcess(String email, String password) throws Exception{
        User user = userRepository.findByEmail(email);
        if(user == null){
            throw new EmailNotFoundException("user not-found .!");
        }
        else if(!user.getPassword().equals(password)){
            throw new WrongPasswordException("wrong password ..!");
        }
        else{
            return user;
        }
    }

}
