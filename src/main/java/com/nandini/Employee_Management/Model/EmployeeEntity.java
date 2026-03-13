package com.nandini.Employee_Management.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id ;

      private String name ;
    private String email;
    private String dept;

      private Long phone;

    private  String designation;
    private Long salary;

}
