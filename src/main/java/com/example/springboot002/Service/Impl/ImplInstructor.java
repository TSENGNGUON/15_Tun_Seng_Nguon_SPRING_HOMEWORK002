package com.example.springboot002.Service.Impl;

import com.example.springboot002.Dto.Request.InstructorRequet;
import com.example.springboot002.Dto.Response.ApiResponse;
import com.example.springboot002.Model.Instructor;
import com.example.springboot002.Repository.InstructorRepository;
import com.example.springboot002.Service.InstructorSeverice;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ImplInstructor implements InstructorSeverice {

    private final InstructorRepository instructorRepository;
    private Instructor instructor;

    public ImplInstructor(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public List<Instructor> getInstructors() {
        return instructorRepository.getInstructors();
    }

    @Override
    public Instructor addInstructor(@RequestBody InstructorRequet instructorRequet) {
        return instructorRepository.addInstructor(instructorRequet);
    }

    @Override
    public Instructor getInstructorById(int id) {
        return instructorRepository.getInstructorById(id);
    }

    @Override
    public Instructor updateInstructor(int id, InstructorRequet instructorRequet) {
        return instructorRepository.updateInstructor(id, instructorRequet);
    }

    @Override
    public Instructor deleteInstructor(int id) {
        return instructorRepository.deleteInstructor(id);
    }
}
