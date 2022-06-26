package com.JSONWebTokens.JWTAuthentication.Repository;

import com.JSONWebTokens.JWTAuthentication.models.ERole;
import com.JSONWebTokens.JWTAuthentication.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
