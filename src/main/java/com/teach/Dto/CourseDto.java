package com.teach.Dto;

import com.teach.Entity.Student.Student;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by 14025 on 2017/5/10.
 */
public class CourseDto {
    private Long id;
    private String courseStartDate;
    private String courseName;
    private String  score;
    private BigDecimal credit;//学分
    private Integer period; //总学时
    private String assessmentMethods;//考核方式
    private String curriculumNature; //课程性质
    private String courseCategory;
    private String studyTime;
    private String classRoom;
    private String testTime;

    private String teacherName;
    private String statue;

    private List<StudentDto> studentDtoList;
    private List<Student> studentList;

    public String getCourseStartDate() {
        return courseStartDate;
    }

    public void setCourseStartDate(String courseStartDate) {
        this.courseStartDate = courseStartDate;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }


    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public String getAssessmentMethods() {
        return assessmentMethods;
    }

    public void setAssessmentMethods(String assessmentMethods) {
        this.assessmentMethods = assessmentMethods;
    }

    public String getCurriculumNature() {
        return curriculumNature;
    }

    public void setCurriculumNature(String curriculumNature) {
        this.curriculumNature = curriculumNature;
    }

    public String getCourseCategory() {
        return courseCategory;
    }

    public void setCourseCategory(String courseCategory) {
        this.courseCategory = courseCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public BigDecimal getCredit() {
        return credit;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<StudentDto> getStudentDtoList() {
        return studentDtoList;
    }

    public void setStudentDtoList(List<StudentDto> studentDtoList) {
        this.studentDtoList = studentDtoList;
    }


    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public String getTestTime() {
        return testTime;
    }

    public void setTestTime(String testTime) {
        this.testTime = testTime;
    }

    public String getStudyTime() {
        return studyTime;
    }

    public void setStudyTime(String studyTime) {
        this.studyTime = studyTime;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getStatue() {
        return statue;
    }

    public void setStatue(String statue) {
        this.statue = statue;
    }
}
