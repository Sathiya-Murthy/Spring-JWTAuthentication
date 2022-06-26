package com.JSONWebTokens.JWTAuthentication.service;

import com.JSONWebTokens.JWTAuthentication.Repository.StudentsRepository;
import com.JSONWebTokens.JWTAuthentication.exception.RollNumberNotFound;
import com.JSONWebTokens.JWTAuthentication.models.Students;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImplementation implements StudentsService{

    private StudentsRepository studentsRepository;

    public StudentServiceImplementation(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    @Override
    public Students saveStudents(Students students) {
        return studentsRepository.save(students);
    }

    @Override
    public List<Students> getAllStudents() {
        return studentsRepository.findAll();
    }

    @Override
    public Students getStudentsByRollNo(int RollNo) {
        return studentsRepository.findById(RollNo).orElseThrow(()->new RollNumberNotFound(RollNo));
    }

    @Override
    public Students updateStudent(Students students,int RollNo) {
        Students existingStudent = studentsRepository.findById(RollNo).orElseThrow(()->new RollNumberNotFound(RollNo));

        existingStudent.setFullName(students.getFullName());
        existingStudent.setGender(students.getGender());
        existingStudent.setClasS(students.getClasS());
        existingStudent.setPhoneNumber(students.getPhoneNumber());
        studentsRepository.save(existingStudent);
        return existingStudent;
    }

    @Override
    public void deleteStudent(int RollNo) {
        studentsRepository.findById(RollNo).orElseThrow(()->new RollNumberNotFound(RollNo));
        studentsRepository.deleteById(RollNo);
    }
}
