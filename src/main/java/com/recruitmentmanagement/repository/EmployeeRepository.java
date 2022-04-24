package com.recruitmentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recruitmentmanagement.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Employee findByUsername(String username);

}
