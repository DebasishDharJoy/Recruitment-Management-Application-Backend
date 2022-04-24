package com.recruitmentmanagement.service.impl;

import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recruitmentmanagement.exception.UserFoundException;
import com.recruitmentmanagement.model.Employee;
import com.recruitmentmanagement.model.EmployeeRole;
//import com.recruitmentmanagement.model.EmployeeSkill;
import com.recruitmentmanagement.repository.EmployeeRepository;
import com.recruitmentmanagement.repository.RoleRepository;
import com.recruitmentmanagement.repository.SkillRepository;
import com.recruitmentmanagement.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private SkillRepository skillRepository;
	
	//creating employee
	@Override
	public Employee createEmployee(Employee employee, Set<EmployeeRole> employeeRoles) throws Exception {

		Employee local = this.employeeRepository.findByUsername(employee.getUsername());
		if(local !=null) {
			System.out.println("User is already there!");
			throw new UserFoundException();
		}
		else {
			//create Employee
			for(EmployeeRole er:employeeRoles) {
				roleRepository.save(er.getRole());
			}
				
			employee.getEmployeeRoles().addAll(employeeRoles);
			
			
			//for skill
//			for (EmployeeSkill employeeSkill : skills) {
//				skillRepository.save(employeeSkill.getSkill());
//			}
//			
//			employee.getEmployeeSkills().addAll(skills);
			local = this.employeeRepository.save(employee);
			
		}
		
		return local;
	}

	//getting employee by username
	@Override
	public Employee getEmployeeByUsername(String username) {
		return this.employeeRepository.findByUsername(username);
	}

	
	//Delete employee by id
	@Override
	public void deleteEmployee(Long employeeId) {
		this.employeeRepository.deleteById(employeeId);
	}




}
