package com.example.springboot002.Controller;

import com.example.springboot002.Dto.Request.CourseRequest;
import com.example.springboot002.Dto.Response.ApiResponse;
import com.example.springboot002.Model.Course;
import com.example.springboot002.Service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Course>>> getAllCourses() {
        ApiResponse<List<Course>> apiResponse = ApiResponse.<List<Course>>builder()
                .message("All courses have been successfully fetched.")
                .payload(courseService.getAllCourses())
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Course>> addCourse(@RequestBody CourseRequest courseRequest) {
        ApiResponse<Course> apiResponse = ApiResponse.<Course>builder()
                .message("The course has been successfully added")
                .payload(courseService.addCourse(courseRequest))
                .status(HttpStatus.CREATED)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Course>> getCourseById(@PathVariable int id){
        ApiResponse<Course> apiResponse = ApiResponse.<Course>builder()
                .message("The course has been successfully founded.")
                .payload(courseService.getCourseById(id))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Course>> updateCourseById(@PathVariable("id") int id,@RequestBody CourseRequest courseRequest){
        ApiResponse<Course> apiResponse = ApiResponse.<Course>builder()
                .message("The course has been successfully founded.")
                .payload(courseService.updateCourseById(id,courseRequest))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Course>> deleteCourseById(@PathVariable("id") int id){
        ApiResponse<Course> apiResponse = ApiResponse.<Course>builder()
                .message("The course has been successfully removed.")
                .payload(courseService.deleteCourseById(id))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
}
