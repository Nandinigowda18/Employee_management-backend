package com.nandini.Employee_Management.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("Searching user: " + username);

        UserEntity user = repo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not found"));

        System.out.println("User found in DB: " + user.getUsername());

        return new User(
                user.getUsername(),
                user.getPassword(),
                new ArrayList<>()
        );
    }
}
