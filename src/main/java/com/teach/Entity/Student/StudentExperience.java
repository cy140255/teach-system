package com.teach.Entity.Student;

import com.util.entity.AggregateRoot;

import javax.persistence.*;

/**
 * Created by 14025 on 2017/5/1.
 */

@Entity
@Table(name = "studentExperience")
public class StudentExperience extends AggregateRoot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = true,unique = true)
    private Long id;


    @Column(name = "startAndEndDate")
    private String startAndEndDate; //开始时间

    @Column(name = "workAddress")
    private String workAddress; //工作地点

    @Column(name = "jobType")
    private String jobType;//工作时间

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartAndEndDate() {
        return startAndEndDate;
    }

    public void setStartAndEndDate(String startAndEndDate) {
        this.startAndEndDate = startAndEndDate;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
