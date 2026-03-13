package com.nandini.Employee_Management.Auth;


import com.nandini.Employee_Management.Security.JwtService;
import com.nandini.Employee_Management.User.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthControllerLogin {
    //has to gen Jwt token

    @Autowired
    private JwtService jwtservice ;

    @Autowired
     private AuthenticationManager manager;

    @Autowired
    private AuthServiceRegister service;

    @PostMapping("/login")
    public String login(@RequestBody UserEntity user){

      Authentication auth = manager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                )
        );
      if(auth.isAuthenticated()){
         return jwtservice.generateToken(user.getUsername());
      }
      throw new RuntimeException("Invalid credentials , authController");
    }

    // REGISTER ENDPOINT
    @PostMapping("/register")
    @ResponseBody
    public String register(@RequestBody UserEntity user){

        service.register(user);

        return "User Registered Successfully";
    }

}
