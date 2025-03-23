package com.example.springboot002.Service.Impl;

import com.example.springboot002.Dto.Request.CourseRequest;
import com.example.springboot002.Model.Course;
import com.example.springboot002.Repository.CourseRepository;
import com.example.springboot002.Service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplCourse implements CourseService {
    private final CourseRepository courseRepository;

    public ImplCourse(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.getAllCourses();
    }

    @Override
    public Course addCourse(CourseRequest courseRequest) {
        return courseRepository.addCourse(courseRequest);
    }

    @Override
    public Course getCourseById(int id) {
        return courseRepository.getCourseById(id);
    }

    @Override
    public Course updateCourseById(int id, CourseRequest courseRequest) {
        return courseRepository.updateCourse(id, courseRequest);
    }

    @Override
    public Course deleteCourseById(int id) {
        return courseRepository.deleteCourseById(id);
    }
}
