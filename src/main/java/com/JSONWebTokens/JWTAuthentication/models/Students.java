package com.JSONWebTokens.JWTAuthentication.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Student")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int RollNo;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String clasS;

    @Column(nullable = false)
    private String phoneNumber;
}
