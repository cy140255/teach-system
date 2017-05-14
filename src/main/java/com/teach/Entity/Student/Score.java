package com.teach.Entity.Student;

import com.teach.Entity.Courses.Course;
import com.util.entity.AggregateRoot;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 14025 on 2017/5/13.
 */
@Entity
@Table(name = "Score")
public class Score extends AggregateRoot{
    @Id
    @Column(name = "ID", nullable = false, unique = true)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;


    @Column(name = "scoreNum")
    private Integer scoreNum;


    @Column(name = "studentId")
    private Integer studentId;

    @Column(name = "courseId")
    private Integer courseId;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getScoreNum() {
        return scoreNum;
    }

    public void setScoreNum(Integer scoreNum) {
        this.scoreNum = scoreNum;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
}


