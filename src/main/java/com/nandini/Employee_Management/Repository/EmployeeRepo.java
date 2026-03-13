package com.nandini.Employee_Management.Repository;

import com.nandini.Employee_Management.Model.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity , Long> {



}
