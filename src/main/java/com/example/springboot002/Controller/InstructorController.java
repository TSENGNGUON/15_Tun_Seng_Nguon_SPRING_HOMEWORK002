package com.example.springboot002.Controller;

import com.example.springboot002.Dto.Request.InstructorRequet;
import com.example.springboot002.Dto.Response.ApiResponse;
import com.example.springboot002.Model.Instructor;
import com.example.springboot002.Service.InstructorSeverice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/instructors")
public class InstructorController {
    private final InstructorSeverice instructorSeverice;

    public InstructorController(InstructorSeverice instructorSeverice) {
        this.instructorSeverice = instructorSeverice;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Instructor>>> getAllInstructors() {
        ApiResponse<List<Instructor>> apiResponse =  ApiResponse.<List<Instructor>>builder()
                .message("All instructors have been successfully fetched.")
                .payload(instructorSeverice.getInstructors())
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Instructor>>  addInstructor(@RequestBody InstructorRequet instructorRequet) {
        ApiResponse<Instructor> apiResponse =  ApiResponse.<Instructor>builder()
                .message("The instructor has been successfully added.")
                .payload(instructorSeverice.addInstructor(instructorRequet))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Instructor>>  getInstructorById(@PathVariable("id") int id) {
        ApiResponse<Instructor> apiResponse = ApiResponse.<Instructor>builder()
                .message("The instructor has been successfully founded.")
                .status(HttpStatus.OK)
                .payload(instructorSeverice.getInstructorById(id))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Instructor>>  updateInstructor(@PathVariable("id") int id, @RequestBody InstructorRequet instructorRequet) {
        ApiResponse<Instructor> apiResponse = ApiResponse.<Instructor>builder()
                .message("The Instructor has been successfully updated.")
                .status(HttpStatus.OK)
                .payload(instructorSeverice.updateInstructor(id,instructorRequet))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Instructor>> deleteInstructorById(@PathVariable("id") int id){

                ApiResponse<Instructor> apiResponse = ApiResponse.<Instructor>builder()
                .message("The instructor has been successfully removed.")
                .status(HttpStatus.OK)
                .payload(instructorSeverice.deleteInstructor(id))
                .timestamp(LocalDateTime.now())
                .build();
          return ResponseEntity.ok(apiResponse);
    }


}
