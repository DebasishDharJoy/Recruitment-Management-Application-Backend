package com.recruitmentmanagement.model;

import javax.persistence.*;

@Entity
public class EmployeeRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeRoleId;

  
    @ManyToOne(fetch = FetchType.EAGER)
    private Employee employee;

    @ManyToOne
    private Role role;

    public EmployeeRole() {
    }

	public Long getEmployeeRoleId() {
		return employeeRoleId;
	}

	public void setEmployeeRoleId(Long employeeRoleId) {
		this.employeeRoleId = employeeRoleId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	

    
}
