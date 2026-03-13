package com.nandini.Employee_Management.Auth;

import com.nandini.Employee_Management.User.UserEntity;
import com.nandini.Employee_Management.User.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceRegister {


    @Autowired
    private UserRepo repo;

    @Autowired
    private PasswordEncoder encoder;

    public void register(UserEntity user){
        user.setPassword(
                encoder.encode(user.getPassword())
        );
        repo.save(user);
    }






}
