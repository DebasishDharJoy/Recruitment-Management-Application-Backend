package com.recruitmentmanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.recruitmentmanagement.model.Employee;
import com.recruitmentmanagement.repository.EmployeeRepository;

@Service
public class EmployeeDetailsServiceImpl implements UserDetailsService{

	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Employee employee = this.employeeRepository.findByUsername(username);
		
		if(employee == null) {
			System.out.println("Employee not found");
			throw new UsernameNotFoundException("No Employee found");
		}
		return employee;
	}

}
