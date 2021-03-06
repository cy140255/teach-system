package com.teach.Mapper;

import com.teach.Dto.CourseDto;
import com.teach.Entity.Courses.Course;
import com.teach.Entity.Student.Student;
import org.apache.ibatis.annotations.Param;

import javax.ws.rs.QueryParam;
import java.util.List;

/**
 * Created by superfq on 2017/3/13.
 */
public interface StudentMapper {
    Student findStuddentById(@Param("userName") String userName, @Param("pwd")String pwd);

    Student findStudent(@Param("studentId") long studentId,@Param("password")String password);

    List<CourseDto> courses(@Param("id")Long id,
                            @Param("courseStartDate")String courseStartDate,
                            @Param("courseName")String courseName,
                            @Param("assessment_Methods")String assessment_Methods,
                            @Param("curriculumNature")String curriculumNature);



    String getScore(@Param("courseId")Long courseId,@Param("studentId")Long studentId);
}
