package com.example.springboot002.Service;

import com.example.springboot002.Dto.Request.InstructorRequet;
import com.example.springboot002.Dto.Response.ApiResponse;
import com.example.springboot002.Model.Instructor;

import java.util.List;

public interface InstructorSeverice {
    public List<Instructor> getInstructors();
    public Instructor addInstructor(InstructorRequet instructorRequet);
    public Instructor getInstructorById(int id);
    public Instructor updateInstructor(int id, InstructorRequet instructorRequet);
    public Instructor deleteInstructor(int id);

}
