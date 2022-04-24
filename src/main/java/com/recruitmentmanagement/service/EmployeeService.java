package com.recruitmentmanagement.service;

import java.util.Optional;
import java.util.Set;

import com.recruitmentmanagement.model.Employee;
import com.recruitmentmanagement.model.EmployeeRole;
//import com.recruitmentmanagement.model.EmployeeSkill;

public interface EmployeeService {

	//Creating Employee
	public Employee createEmployee(Employee employee, Set<EmployeeRole> employeeRoles) throws Exception;
	
	//get employee by username
	public Employee getEmployeeByUsername(String username);
	
	
	//delete employee by id
	public void deleteEmployee(Long employeeId);

}
