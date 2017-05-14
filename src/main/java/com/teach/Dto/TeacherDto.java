package com.teach.Dto;

import com.teach.Entity.Courses.Course;
import com.teach.Entity.Student.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 14025 on 2017/5/12.
 */
public class TeacherDto {
    private String teacherName;
    private List<Student> studentList = new ArrayList<>();
    private CourseListDto courseListDto ;

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public CourseListDto getCourseListDto() {
        return courseListDto;
    }

    public void setCourseListDto(CourseListDto courseListDto) {
        this.courseListDto = courseListDto;
    }
}
