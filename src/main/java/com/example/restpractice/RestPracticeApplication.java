package com.example.restpractice;

import com.example.restpractice.model.Employee;
import com.example.restpractice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestPracticeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RestPracticeApplication.class, args);
	}

	@Autowired
	private EmployeeService employeeService;

	@Override
	public void run(String... args) throws Exception {
//		Employee employee = new Employee();
//		employee.setFirstName("Sohail");
//		employee.setLastName("Khan");
//		employee.setEmail("email1234@gmail.com");
//		employeeService.addEmployeeToDb(employee);
//
//		Employee employee2 = new Employee();
//		employee2.setFirstName("James");
//		employee2.setLastName("May");
//		employee2.setEmail("may1234@gmail.com");
//		employeeService.addEmployeeToDb(employee2);
	}
}
