package com.smiloutcha.employeemanager.services;

import com.smiloutcha.employeemanager.entities.Employee;
import com.smiloutcha.employeemanager.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Service
public class EmployeeService {

    private  final EmployeeRepository employeeRepository ;
    public Collection<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee findEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id) ;
        boolean isEmployeePresentInDb  = employee.isPresent() ;
        if (isEmployeePresentInDb)
            return  employee.get();
        else
            throw new IllegalArgumentException("employee with id " + id + " does not exist");
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee) {
        Optional<Employee> employeeFromDb = employeeRepository.findById(employee.getId()) ;
        if (employeeFromDb.isPresent()) {
            return doMappingAndSave(employeeFromDb.get(),employee);
        } else {
            throw new IllegalArgumentException("employee given does not exist in the database");
        }
    }

    private Employee doMappingAndSave(Employee employeeFromDb, Employee employee) {
        employeeFromDb.setFirstName(employee.getFirstName());
        employeeFromDb.setEmail(employee.getEmail());
        employeeFromDb.setImageUrl(employee.getImageUrl());
        employeeFromDb.setPhone(employee.getPhone());
        return employeeRepository.save(employee);
    }

    public Employee removeAndGetEmployeeById(Long id) {
        Employee employeeFromDb = employeeRepository.findById(id).orElse(null) ;
        if (!Objects.isNull(employeeFromDb)) {
            employeeRepository.deleteById(id);
            return  employeeFromDb;
        } else {
            throw  new IllegalArgumentException("employee already doesnt exist in the db");
        }
    }
}
