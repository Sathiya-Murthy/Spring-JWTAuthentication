package com.JSONWebTokens.JWTAuthentication.exception;

public class RollNumberNotFound extends RuntimeException {
    private Integer RollNo;

    public RollNumberNotFound(Integer rollNo) {
        super(String.format("RollNumber not found %s",rollNo));
        RollNo = rollNo;
    }
}
