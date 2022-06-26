package com.JSONWebTokens.JWTAuthentication.Repository;

import com.JSONWebTokens.JWTAuthentication.models.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<Students,Integer> {
}
