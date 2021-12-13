package com.example.restpractice.service;

import com.example.restpractice.model.Employee;
import com.example.restpractice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee addOrUpdateEmployeeToDb(Employee employee){
        return employeeRepository.save(employee);
    }

    public Optional<Employee> findEmployeeById(long id){
        return employeeRepository.findById(id);

    }

    public void deleteEmployee(Employee employee){
        employeeRepository.delete(employee);
    }
}
