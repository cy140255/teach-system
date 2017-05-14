package com.teach.Entity.Student;

import com.util.entity.AggregateRoot;

import javax.persistence.*;

/**
 * Created by 14025 on 2017/5/1.
 */
@Entity
@Table(name = "StduentFamilyInfo")
public class StudentFamilyInfo extends AggregateRoot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = true,unique = true)
    private Long Id;

    @Column(name = "FamilyName")
    private String familyName;

    @Column(name = "relationship")
    private String relationship;

    @Column(name = "workAddress")
    private String workAddress;

    @Column(name = "jobType")
    private String jobType;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
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
