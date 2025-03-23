package com.example.springboot002.Dto.Request;

import com.example.springboot002.Model.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    private String studentName;
    private  String email;
    private String phoneNumber;
    private List<Integer> course_id;
}
