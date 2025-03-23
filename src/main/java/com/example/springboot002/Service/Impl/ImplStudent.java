package com.example.springboot002.Service.Impl;

import com.example.springboot002.Dto.Request.StudentRequest;
import com.example.springboot002.Model.Student;
import com.example.springboot002.Repository.CourseRepository;
import com.example.springboot002.Repository.StudentRepository;
import com.example.springboot002.Service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplStudent implements StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public ImplStudent(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    @Override
    public Student addStudent(StudentRequest studentRequest) {
        Student student = studentRepository.addStudent(studentRequest);
        for (Integer courseId : studentRequest.getCourse_id()){
            courseRepository.addStudentIdAndCourseID(student.getStudentId(), courseId);
        }
        return getStudentById(student.getStudentId());
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.getStudentById(id);
    }


}
