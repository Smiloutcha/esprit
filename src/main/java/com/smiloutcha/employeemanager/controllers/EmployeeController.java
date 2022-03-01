package com.smiloutcha.employeemanager.controllers;


import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smiloutcha.employeemanager.entities.Employee;
import com.smiloutcha.employeemanager.services.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/employees")
@AllArgsConstructor
@CrossOrigin("*")
public class EmployeeController {

    private final EmployeeService employeeService ;

    @GetMapping(path = "/search/all")
    public ResponseEntity<Collection<Employee>> findAllEmployees() {
        Collection<Employee> employees = employeeService.findAllEmployees() ;
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping(path = "/search/{id}")
    public ResponseEntity<Employee> findById(@PathVariable("id") Long id ) {
        Employee employee = employeeService.findEmployeeById(id) ;
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @PostMapping(path = "/save")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee) ;
        return new ResponseEntity<>(savedEmployee,HttpStatus.OK);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Employee> updateEmployee (@RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.updateEmployee(employee) ;
        return new ResponseEntity<>(updatedEmployee,HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") Long id ) {
        Employee removedEmployee = employeeService.removeAndGetEmployeeById(id) ;
        return new ResponseEntity<>(removedEmployee,HttpStatus.OK) ;
    }


}
