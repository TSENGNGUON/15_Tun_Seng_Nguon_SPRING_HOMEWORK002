package com.example.springboot002.Repository;

import com.example.springboot002.Dto.Request.StudentRequest;
import com.example.springboot002.Model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentRepository {
    @Select("""
        select st.student_id, st.student_name, st.email, st.phone_number, sc.course_id from students as st inner join student_course as sc on st.student_id = sc.student_id;
""")
    @Results(id = "studentMapper", value = {
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "email", column = "email"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "courses", column = "course_id", many = @Many(select = "com.example.springboot002.Repository.CourseRepository.getCourseById"))
    })
    public List<Student> getAllStudents();


    @Insert("""
    INSERT INTO students (student_name, email, phone_number) VALUES (#{request.studentName}, #{request.email}, #{request.phoneNumber})
    """)
    @ResultMap("studentMapper")
    Student addStudent(@Param("request") StudentRequest studentRequest);
}
