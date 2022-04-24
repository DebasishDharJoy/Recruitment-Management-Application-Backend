package com.recruitmentmanagement.model.skill;

import javax.persistence.*;

import com.recruitmentmanagement.model.Employee;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long sId;
	
	private String title;
	
//	@ManyToOne(fetch = FetchType.EAGER)
//	private Category category;
	
	@ManyToMany
	@JoinTable (
			name= "Employee_Skill_new",
			joinColumns= @JoinColumn(name = "skill_id"),
			inverseJoinColumns= @JoinColumn(name = "Employee_id")
	)
	private Set<Employee> employees = new HashSet<>();

	public Skill() {
	}

	public Skill(String title) {
		super();
		this.title = title;
	}

	public Long getsId() {
		return sId;
	}

	public void setsId(Long sId) {
		this.sId = sId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	
	
	
	
}

//package com.recruitmentmanagement.model;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "skills")
//public class Skill {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long skillId;
//	private String skillName;
//	
//
//	@OneToMany(cascade = CascadeType.ALL, fetch= FetchType.EAGER, mappedBy = "skill")
//	private Set<EmployeeSkill> employeeSkill = new HashSet<>();
//	
//	public Skill() {
//		super();
//	}
//
//	public Skill(String skillName) {
//		super();
//		
//		this.skillName = skillName;
//	}
//
//	public Long getSkillId() {
//		return skillId;
//	}
//
//	public void setSkillId(Long skillId) {
//		this.skillId = skillId;
//	}
//
//	public String getSkillName() {
//		return skillName;
//	}
//
//	public void setSkillName(String skillName) {
//		this.skillName = skillName;
//	}
//
//	public Set<EmployeeSkill> getEmployeeSkill() {
//		return employeeSkill;
//	}
//
//	public void setEmployeeSkill(Set<EmployeeSkill> employeeSkill) {
//		this.employeeSkill = employeeSkill;
//	}
//
//}
