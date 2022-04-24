package com.recruitmentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recruitmentmanagement.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
