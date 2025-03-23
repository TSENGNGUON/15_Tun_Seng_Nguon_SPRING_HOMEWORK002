package com.example.springboot002.Service;

import com.example.springboot002.Dto.Request.CourseRequest;
import com.example.springboot002.Model.Course;

import java.util.List;

public interface CourseService {
    public List<Course> getAllCourses();
    public Course addCourse(CourseRequest courseRequest);
    public Course getCourseById(int id);
    public Course updateCourseById(int id, CourseRequest courseRequest);
    public Course deleteCourseById(int id);
}
