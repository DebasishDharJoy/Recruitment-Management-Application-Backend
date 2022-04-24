package com.recruitmentmanagement.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recruitmentmanagement.exception.UserFoundException;
import com.recruitmentmanagement.exception.UserNotFoundException;
import com.recruitmentmanagement.model.Employee;
import com.recruitmentmanagement.model.EmployeeRole;
import com.recruitmentmanagement.model.Role;
import com.recruitmentmanagement.repository.EmployeeRepository;
import com.recruitmentmanagement.service.EmployeeService;


@RestController
@RequestMapping("/employee")
//@CrossOrigin("http://localhost:4200")
@CrossOrigin("*")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private BCryptPasswordEncoder	bCryptPasswordEncoder;

	// Creating Employee
	@PostMapping("/")
	public Employee createEmployee(@RequestBody Employee employee) throws Exception {

		employee.setProfile("default.png");
		
		//encoding password with bcryptpasswordencoder
		
		employee.setPassword(this.bCryptPasswordEncoder.encode(employee.getPassword()));
		
		Set<EmployeeRole> roles = new HashSet<>();
//		Set<EmployeeSkill> skills = new HashSet<>();

		Role role = new Role();
		role.setRoleId(45L);
		role.setRoleName("Employee");
		
//		Skill skill = new Skill();
//		skill.setSkillName("");

		EmployeeRole employeeRole = new EmployeeRole();
		employeeRole.setEmployee(employee);
		employeeRole.setRole(role);

		roles.add(employeeRole);
		
//		EmployeeSkill employeeSkill = new EmployeeSkill();
//		employeeSkill.setEmployee(employee);
//		employeeSkill.setSkill(skill);
//		
//		skills.add(employeeSkill);
		

		return this.employeeService.createEmployee(employee, roles);
	}

	// get employee
	@GetMapping("/{username}")
	public Employee getEmployee(@PathVariable("username") String username) {
		return this.employeeService.getEmployeeByUsername(username);
	}
	
	//get employee by id
	@GetMapping("/{id")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) throws UserNotFoundException{
		
		Employee employee = employeeRepository.findById(id).orElseThrow(()-> new UserNotFoundException("Employee not found"));
		return ResponseEntity.ok(employee);
	}
	
	// get all employee
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	// delete employee by id
	@DeleteMapping("/{employeeId}")
	public void deleteEmployee(@PathVariable("employeeId") Long employeeId) {
		this.employeeService.deleteEmployee(employeeId);
	}

	// update employee
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) throws UserNotFoundException{
		
		Employee existingEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("Employee does not exist"));
		
				
			existingEmployee.setFirstName(employee.getFirstName());
			existingEmployee.setLastName(employee.getLastName());
			existingEmployee.setEmail(employee.getEmail());
			existingEmployee.setUsername(employee.getUsername());
			existingEmployee.setPhone(employee.getPhone());
//			existingEmployee.setEmployeeSkills(employee.getEmployeeSkills());
			
			
			Employee updatedEmployee = employeeRepository.save(employee);
			return ResponseEntity.ok(updatedEmployee);
		
	}
	
	
	
	@ExceptionHandler(UserFoundException.class)
    public ResponseEntity<?> exceptionHandler(UserFoundException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }
	
	
}
