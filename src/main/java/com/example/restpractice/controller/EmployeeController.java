package com.example.restpractice.controller;

import com.example.restpractice.exception.ResourceNotFoundException;
import com.example.restpractice.model.Employee;
import com.example.restpractice.repository.EmployeeRepository;
import com.example.restpractice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.findAllEmployees();
    }

    @PostMapping()
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.addOrUpdateEmployeeToDb(employee);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable  long id){
        Employee employee = employeeService.findEmployeeById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id:" + id));
        return ResponseEntity.ok(employee);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails){
        Employee updatedEmployee = employeeService.findEmployeeById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id:" + id));

        updatedEmployee.setFirstName(employeeDetails.getFirstName());
        updatedEmployee.setLastName(employeeDetails.getLastName());
        updatedEmployee.setEmail(employeeDetails.getEmail());

        employeeService.addOrUpdateEmployeeToDb(updatedEmployee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){

        Employee employee = employeeService.findEmployeeById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id:" + id));

        employeeService.deleteEmployee(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
