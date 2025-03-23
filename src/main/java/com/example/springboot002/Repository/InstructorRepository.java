package com.example.springboot002.Repository;

import com.example.springboot002.Dto.Request.InstructorRequet;
import com.example.springboot002.Dto.Response.ApiResponse;
import com.example.springboot002.Model.Instructor;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface InstructorRepository {

    @Select("""
        SELECT * FROM instructors
""")
    @Results(id = "instructorMapper", value = {
            @Result(property = "instructorId", column = "instructor_id"),
            @Result(property = "instructorName", column = "instructor_name"),
    })
    public List<Instructor> getInstructors();

    @Select("""
        INSERT INTO instructors (instructor_name,email)
        VALUES (#{request.instructorName}, #{request.email})  returning *
""")
    @ResultMap("instructorMapper")
    public Instructor addInstructor(@Param("request") InstructorRequet instructorRequet);


    @Select("""
        SELECT * FROM instructors WHERE instructor_id = #{id}
""")
    @ResultMap("instructorMapper")
    public Instructor getInstructorById(int id);

    @Select("""
        UPDATE instructors SET instructor_name = #{request.instructorName}, email = #{request.email}  WHERE instructor_id = #{id} returning *
""")
    @ResultMap("instructorMapper")
    public Instructor updateInstructor(int id,@Param("request") InstructorRequet instructorRequet);



    @Delete("""
        DELETE FROM instructors WHERE instructor_id = #{id} returning *
""")
    @ResultMap("instructorMapper")
    public Instructor deleteInstructor(int id);
}
