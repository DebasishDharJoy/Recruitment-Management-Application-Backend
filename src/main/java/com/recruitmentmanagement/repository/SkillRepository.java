package com.recruitmentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.recruitmentmanagement.model.skill.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {

}
