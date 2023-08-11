package com.fullstack.backendApp.controller;

import com.fullstack.backendApp.exception.EmployeeNotFoundException;
import com.fullstack.backendApp.model.Employee;
import com.fullstack.backendApp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/employee")
    Employee newEmployee(@RequestBody Employee newEmployee) {
        return employeeRepository.save(newEmployee);
    }

    @GetMapping("/employees")
    List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employee/{id}")
    Employee getEmployeeById(@PathVariable Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(()->new EmployeeNotFoundException(id));
    }

    @PutMapping("/employee/{id}")
    Employee updateEmpl (@RequestBody Employee newEmpl, @PathVariable Long id){
        return employeeRepository.findById(id)
                .map(e -> {
                    e.setFirstName(newEmpl.getFirstName());
                    e.setMiddleName(newEmpl.getMiddleName());
                    e.setLastName(newEmpl.getLastName());
                    e.setLocationCity(newEmpl.getLocationCity());
                    e.setAddress(newEmpl.getAddress());
                    e.setDateOfBirth(newEmpl.getDateOfBirth());
                    e.setTelephone(newEmpl.getTelephone());
                    e.setPositionTitle(newEmpl.getPositionTitle());
                    e.setHireDate(newEmpl.getHireDate());
                    e.setEmail(newEmpl.getEmail());
                    e.setSalary(newEmpl.getSalary());
                    e.setTimeInPosition(newEmpl.getTimeInPosition());
                    e.setDateArrival(newEmpl.getDateArrival());
                    e.setStatus(newEmpl.getStatus());

                    return employeeRepository.save(e);
                }).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @DeleteMapping("/employee/{id}")
    String deleteEmployee(@PathVariable Long id) {
        if(!employeeRepository.existsById(id)) {
            throw new EmployeeNotFoundException(id);
        }
        employeeRepository.deleteById(id);
        return "Employee by id " +id+ " has been deleted successfully";
    }
}

