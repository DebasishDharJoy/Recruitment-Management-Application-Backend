package com.recruitmentmanagement.model;


import java.util.Collection; 
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.recruitmentmanagement.model.skill.Skill;


@Entity
@Table(name="employees")
public class Employee implements UserDetails{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private boolean enabled = true;
	private String profile;
	
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy = "employee")
	@JsonIgnore
	private Set<EmployeeRole> employeeRoles = new HashSet<>();
	
	@ManyToMany(mappedBy = "employees")
	private Set<Skill> skills = new HashSet<>();
	
	
//	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy = "employee")
//	private Set<EmployeeSkill> employeeSkills = new HashSet<>();


	public Employee() {
		super();
	}


	public Employee(Long id, String username, String password, String firstName, String lastName, String email,
			String phone, boolean enabled, String profile) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.enabled = enabled;
		this.profile = profile;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public String getProfile() {
		return profile;
	}


	public void setProfile(String profile) {
		this.profile = profile;
	}


	public Set<EmployeeRole> getEmployeeRoles() {
		return employeeRoles;
	}


	public void setEmployeeRoles(Set<EmployeeRole> employeeRoles) {
		this.employeeRoles = employeeRoles;
	}
	


//	public Set<EmployeeSkill> getEmployeeSkills() {
//		return employeeSkills;
//	}
//
//
//	public void setEmployeeSkills(Set<EmployeeSkill> employeeSkills) {
//		this.employeeSkills = employeeSkills;
//	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Set<Authority> set = new HashSet<>();
		
		this.employeeRoles.forEach(employeeRole -> {
			set.add(new Authority(employeeRole.getRole().getRoleName()));
		});
		
		return set;
	}


	public Set<Skill> getSkills() {
		return skills;
	}


	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}


	@Override
	public boolean isAccountNonExpired() {
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}



	


	

}
