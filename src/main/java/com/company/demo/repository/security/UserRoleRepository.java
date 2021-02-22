package com.company.demo.repository.security;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.demo.entities.security.RoleName;
import com.company.demo.entities.security.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
	
	Optional<UserRole> findByName(RoleName roleName);

}
