package com.nandini.Employee_Management.Controller;


import com.nandini.Employee_Management.Model.EmployeeEntity;
import com.nandini.Employee_Management.Service.EmployeServiceImp;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.element.NestingKind;
import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeServiceImp service ;



    @PostMapping("/add")
    public String AddEmployee(@RequestBody EmployeeEntity enity){
        System.out.println("ADD EMPLOYEE API HIT");

        System.out.println(enity);

      return  service.addEmployee(enity);


    }


    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees(){
        List<EmployeeEntity> list = service.getAllEmployees();
        return ResponseEntity.ok(list); // even if empty
    }



    //get by id

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeEntity> getByID(@PathVariable Long id) {

        EmployeeEntity emp = service.getByID(id);

        if (emp == null) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok(emp);

    }




    //update

    @PutMapping("/update/{id}")

    public ResponseEntity<EmployeeEntity> updateEployee(@PathVariable Long id ,
                                                        @RequestBody EmployeeEntity entity){

       EmployeeEntity employee = service.updateEmployee(id ,entity);

       if(employee == null){
         return  ResponseEntity.status(404).body(null);
       }

      return ResponseEntity.ok(employee);
    }



    @DeleteMapping("/delete/{id}")

    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){

         service.deleteEmployee(id);

         return ResponseEntity.ok("Employee Deleted Successfully");

       }






    }






