package com.example.springboot002.Dto.Request;

import com.example.springboot002.Model.Instructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {
    private String courseName;
    private String description;
    private int instructor_id;
}
