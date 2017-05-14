package com.teach.Mapper;

import com.teach.Dto.CourseDto;
import com.teach.Entity.Student.Score;
import com.teach.Entity.Student.Student;
import com.teach.Entity.Teacher.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 14025 on 2017/5/12.
 */
public interface TeacherMapper {

    Teacher findTeacher(@Param("teacherId") long teacherId, @Param("password")String password);



    List<CourseDto> courses(@Param("id")Long id,
                            @Param("courseStartDate")String courseStartDate,
                            @Param("courseName")String courseName,
                            @Param("assessment_Methods")String assessment_Methods,
                            @Param("curriculumNature")String curriculumNature);

    Score getScore(@Param("studentId")Integer studentId,@Param("courseId")Integer courseId);
    void upScore(@Param("scoreNum")Integer scoreNum,@Param("id")Long id);




}
