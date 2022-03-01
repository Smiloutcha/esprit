package com.smiloutcha.employeemanager;

import com.smiloutcha.employeemanager.entities.Employee;
import com.smiloutcha.employeemanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.UUID;

@SpringBootApplication
@CrossOrigin("*")
public class EmployeemanagerApplication  implements CommandLineRunner {


    @Autowired
    private EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(EmployeemanagerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Employee employee = Employee.builder()
                .id(null)
                .firstName("Smiloutcha")
                .employeeCode(UUID.randomUUID().toString())
                .email("smiloutcha@live.com")
                .phone("021312312312")
                .imageUrl("Url Image")
                .build();
        employeeRepository.save(employee);
    }
}
