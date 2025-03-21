package com.example.springboot002.Service.Impl;

import com.example.springboot002.Model.Student;
import com.example.springboot002.Service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplStudent implements StudentService {
    @Override
    public List<Student> getAllStudents() {
        return null;
    }
}
