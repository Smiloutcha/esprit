package com.smiloutcha.employeemanager.repository;

import com.smiloutcha.employeemanager.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository  extends JpaRepository<Employee,Long> {
}
