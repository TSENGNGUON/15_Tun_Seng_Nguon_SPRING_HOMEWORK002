package com.example.springboot002.Service.Impl;

import com.example.springboot002.Dto.Request.StudentRequest;
import com.example.springboot002.Model.Student;
import com.example.springboot002.Repository.StudentRepository;
import com.example.springboot002.Service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplStudent implements StudentService {
    private final StudentRepository studentRepository;

    public ImplStudent(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    @Override
    public Student addStudent(StudentRequest studentRequest) {
        return studentRepository.addStudent(studentRequest);
    }


}
