package com.teach.Entity.Courses;

import com.teach.Entity.Student.Score;
import com.teach.Entity.Student.Student;
import com.teach.Entity.Teacher.Teacher;
import com.util.entity.AggregateRoot;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static java.util.Objects.isNull;
/**
 * Created by 14025 on 2017/5/10.
 */
@Entity
@Table(name = "course")
public class Course extends AggregateRoot{

    @Id
    @Column(name = "ID", nullable = false, unique = true)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "courseStartDate")
    private String courseStartDate;

    @Column(name = "courseName")
    private String courseName;

    @Column(name = "credit")
    private BigDecimal credit;//学分

    @Column(name = "period")
    private Integer period; //总学时

    @Column(name = "assessmentMethods")
    private String assessmentMethods;//考核方式

    @Column(name = "curriculumNature")
    private String curriculumNature; //课程性质

    @Column(name = "courseCategory")
    private String courseCategory;


    @Column(name = "classroom")
    private String classroom;

    @Column(name = "testTime")
    private String testTime;

    @Column(name = "studyTime")
    private String studyTime;

    @Column(name = "teacherName")
    private String teacherName;


    @Column(name = "studyClassRoom")
    private String studyClassRoom;

    @Column(name = "statue")
    private String statue;
    @ManyToMany
    @JoinTable( name = "course_student",
            joinColumns = {@JoinColumn(name = "course_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id",referencedColumnName = "id")})
    private List<Student> students = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "course_teacher",
            joinColumns = {@JoinColumn(name = "course_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "teacher_id",referencedColumnName = "id")})
    private List<Teacher> teacherList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public BigDecimal getCredit() {
        return credit;
    }


    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
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

        if (isNull(studyTime)){
            this.studyTime ="暂无数据";
        }else {
            this.studyTime = studyTime;
        }


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

    public String getStudyClassRoom() {
        return studyClassRoom;
    }

    public void setStudyClassRoom(String studyClassRoom) {
        this.studyClassRoom = studyClassRoom;
    }
}
