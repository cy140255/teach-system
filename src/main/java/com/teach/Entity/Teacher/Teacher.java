package com.teach.Entity.Teacher;

import com.teach.Entity.Courses.Course;
import com.teach.Entity.Student.Student;
import com.util.entity.AggregateRoot;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 14025 on 2017/5/12.
 */

@Entity
@Table(name = "teacher")
public class Teacher extends AggregateRoot {

    @Id
    @Column(name = "ID", nullable = false, unique = true)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "teacherId")
    private Long teacherId; //教师号

    @Column(name = "password")
    private String password;

    @Column(name = "teacherName")
    private String teacherName;



    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "teacher_student",
            joinColumns = {@JoinColumn(name="teacher_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="student_id",referencedColumnName = "id")})
    private List<Student> studentList = new ArrayList<>();


    @ManyToMany(mappedBy = "teacherList",fetch = FetchType.EAGER)
    private List<Course> courseList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
