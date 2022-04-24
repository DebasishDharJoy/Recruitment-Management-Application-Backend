//package com.recruitmentmanagement.model;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//
//import com.recruitmentmanagement.model.skill.Skill;
//
//@Entity
//public class EmployeeSkill {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long employeeSkillId;
//
//	@ManyToOne(fetch = FetchType.EAGER)
//	private Employee employee;
//
//	@ManyToOne(fetch = FetchType.EAGER)
//	private Skill skill;
//
//	public EmployeeSkill() {
//		super();
//	}
//
//	public Long getEmployeeSkillId() {
//		return employeeSkillId;
//	}
//
//	public void setEmployeeSkillId(Long employeeSkillId) {
//		this.employeeSkillId = employeeSkillId;
//	}
//
//	public Employee getEmployee() {
//		return employee;
//	}
//
//	public void setEmployee(Employee employee) {
//		this.employee = employee;
//	}
//
//	public Skill getSkill() {
//		return skill;
//	}
//
//	public void setSkill(Skill skill) {
//		this.skill = skill;
//	}
//	
//	
//
//}
