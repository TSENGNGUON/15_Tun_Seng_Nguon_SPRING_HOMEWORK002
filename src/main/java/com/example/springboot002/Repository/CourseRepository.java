package com.example.springboot002.Repository;

import com.example.springboot002.Dto.Request.CourseRequest;
import com.example.springboot002.Model.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseRepository {
    @Select("""
    SELECT * FROM courses
""")
    @Results(id = "courseMapper", value = {
            @Result(property = "courseId" , column = "course_id"),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "description", column = "description"),
            @Result(
                    property = "instructor",
                    column = "instructor_id",
                    one = @One(select = "com.example.springboot002.Repository.InstructorRepository.getInstructorById"))
    })
    public List<Course> getAllCourses();

    @Select("""
    INSERT INTO courses (course_name, description, instructor_id) 
    VALUES (#{request.courseName}, #{request.description}, #{request.instructor_id})
    returning *
""")
    @ResultMap("courseMapper")
    public Course addCourse (@Param("request") CourseRequest courseRequest);

    @Select("""
    SELECT * FROM courses WHERE course_id = #{id} 
""")
    @ResultMap("courseMapper")
    public Course getCourseById(int id);

    @Select("""
    UPDATE courses SET course_name = #{request.courseName}, description = #{request.description}, instructor_id = #{request.instructor_id} WHERE course_id = #{id} returning *
""")
    @ResultMap("courseMapper")
    public Course updateCourse (int id, @Param("request") CourseRequest courseRequest);


    @Select("""
    DELETE  FROM courses WHERE course_id = #{id} returning *
""")
    @ResultMap("courseMapper")
    public Course deleteCourseById(int id);

}




