package com.example.springboot002.Controller;


import com.example.springboot002.Dto.Response.ApiResponse;
import com.example.springboot002.Model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    @GetMapping
    public ResponseEntity<ApiResponse<List<Student>>> getStudents() {

        return null;
    }

}
