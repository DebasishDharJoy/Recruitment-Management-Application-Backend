package com.recruitmentmanagement;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.recruitmentmanagement.exception.UserFoundException;
import com.recruitmentmanagement.model.Employee;
import com.recruitmentmanagement.model.EmployeeRole;
import com.recruitmentmanagement.model.Role;
import com.recruitmentmanagement.service.EmployeeService;

@SpringBootApplication
public class RecruitmentmanagementserverApplication implements CommandLineRunner {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(RecruitmentmanagementserverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Demo
//		try {
//		System.out.println("Starting code");
//		
//		Employee employee = new Employee();
//		employee.setFirstName("Debasish");
//		employee.setLastName("Dhar");
//		employee.setUsername("employer");
//		employee.setPassword(this.bCryptPasswordEncoder.encode("employer"));
//		employee.setEmail("employer@gmail.com");
//		employee.setProfile("default.png");
//		
//		Role role1 = new Role();
//		role1.setRoleId(44L);
//		role1.setRoleName("EMPLOYER");
//		
//		Set<EmployeeRole> employeeRoleSet = new HashSet<>();
//		EmployeeRole employeeRole = new EmployeeRole();
//		employeeRole.setRole(role1);
//		employeeRole.setEmployee(employee);
//		
//		employeeRoleSet.add(employeeRole);
//		
//		
//		Employee employee1 = this.employeeService.createEmployee(employee, employeeRoleSet);
//		System.out.println(employee1.getUsername());
//		
//		}
//		catch(UserFoundException e){
//			e.printStackTrace();
//		}
//			
		}
	}


