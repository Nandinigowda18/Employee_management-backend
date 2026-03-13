package com.nandini.Employee_Management.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.function.LongFunction;

@Entity
@Data
public class UserEntity {


    @Id
    @GeneratedValue
    private Long id ;

    private String username ;
    private String password;


}
