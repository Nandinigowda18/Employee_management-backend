package com.nandini.Employee_Management.Service;

import com.nandini.Employee_Management.Model.EmployeeEntity;
import com.nandini.Employee_Management.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeServiceImp {

    @Autowired
    private EmployeeRepo repo;

    public String addEmployee(EmployeeEntity enity) {

        int phoneLength = String.valueOf(enity.getPhone()).length();

        if(enity.getEmail().length() <= 2 || !enity.getEmail().contains("@") || phoneLength != 10){
            return "Invalid Credentials";
        }

        repo.save(enity);

        return "Employee Added Successfully";
    }

    public EmployeeEntity getByID(Long id) {

        return  repo.findById(id).orElseThrow(
                ()-> new RuntimeException(" can't find the Employee"));

    }

    public List<EmployeeEntity> getAllEmployees() {

       return  repo.findAll();

    }

    public EmployeeEntity updateEmployee(Long id , EmployeeEntity entity) {

         EmployeeEntity employee =  repo.findById(id).orElseThrow(
                 ()-> new RuntimeException("NO Employeee found"));

        employee.setName(entity.getName());
        employee.setEmail(entity.getEmail());
        employee.setDept(entity.getDept());
        employee.setPhone(entity.getPhone());
        employee.setDesignation(entity.getDesignation());
        employee.setSalary(entity.getSalary());

         return repo.save(employee);

    }

    public void deleteEmployee(Long id) {

        EmployeeEntity employee = repo.findById(id).orElseThrow(
                ()-> new RuntimeException(" No Employee Found "+id ));
        repo.delete(employee);

    }
}


