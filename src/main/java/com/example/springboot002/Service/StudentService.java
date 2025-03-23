package com.example.springboot002.Service;

import com.example.springboot002.Dto.Request.StudentRequest;
import com.example.springboot002.Model.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudents();

    Student addStudent(StudentRequest studentRequest);
}

