//package com.recruitmentmanagement.model.skill;
//
//import java.util.LinkedHashSet;
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
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//@Entity
//@Table(name = "category")
//public class Category {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long cid;
//	private String title;
//	
//	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JsonIgnore
//	private Set<Skill> skills = new LinkedHashSet<>();
//	
//	
//	public Category() {
//		super();
//	}
//
//
//	public Category (String title) {
//		
//		
//		this.title = title;
//	}
//
//
//	public Long getCid() {
//		return cid;
//	}
//
//
//	public void setCid(Long cid) {
//		this.cid = cid;
//	}
//
//
//	public String getTitle() {
//		return title;
//	}
//
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//	
//	
//	
//}
