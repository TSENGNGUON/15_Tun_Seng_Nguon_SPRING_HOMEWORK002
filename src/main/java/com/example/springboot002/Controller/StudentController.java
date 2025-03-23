package com.example.springboot002.Controller;


import com.example.springboot002.Dto.Request.StudentRequest;
import com.example.springboot002.Dto.Response.ApiResponse;
import com.example.springboot002.Model.Instructor;
import com.example.springboot002.Model.Student;
import com.example.springboot002.Service.StudentService;
import jakarta.servlet.ServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Student>>> getStudents() {
        ApiResponse<List<Student>> apiResponse = ApiResponse.<List<Student>>builder()
                .message("All students have been successfully fetched.")
                .status(HttpStatus.OK)
                .payload(studentService.getAllStudents())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Student>> addStudent(@RequestBody StudentRequest  studentRequest) {
        ApiResponse<Student> apiResponse = ApiResponse.<Student>builder()
                .message("All students have been successfully fetched.")
                .status(HttpStatus.OK)
                .payload(studentService.addStudent(studentRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }



}
