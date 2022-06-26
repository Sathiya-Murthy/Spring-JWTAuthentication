package com.JSONWebTokens.JWTAuthentication.controller;

import com.JSONWebTokens.JWTAuthentication.models.Students;
import com.JSONWebTokens.JWTAuthentication.service.StudentsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/database")
public class StudentController {
    StudentsService studentsService;

    public StudentController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Students> saveStudents(@RequestBody Students students){
        return new ResponseEntity<Students>(studentsService.saveStudents(students), HttpStatus.CREATED);
    }
    @GetMapping
    public List<Students> getAllStudents(){
        return (studentsService.getAllStudents());
    }
    @GetMapping("{RollNo}")
    public ResponseEntity<Students> getStudentsByRollNo(@PathVariable int RollNo){
        return new ResponseEntity<Students>(studentsService.getStudentsByRollNo(RollNo),HttpStatus.OK);
    }
    @PutMapping("{RollNo}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Students> updateStudent(@PathVariable int RollNo,@RequestBody Students students){
        return new  ResponseEntity<Students>(studentsService.updateStudent(students,RollNo),HttpStatus.OK);
    }
    @DeleteMapping("{RollNo}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteStudent(@PathVariable int RollNo){
        studentsService.deleteStudent(RollNo);
        return new ResponseEntity<String >("Student data deleted",HttpStatus.OK);
    }
}
