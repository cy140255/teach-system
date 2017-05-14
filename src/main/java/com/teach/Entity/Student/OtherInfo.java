package com.teach.Entity.Student;

import com.util.entity.AggregateRoot;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by 14025 on 2017/5/1.
 */
@Entity
@Table(name = "OtherInfo")
public class OtherInfo extends AggregateRoot {
    @Id
    @Column(name = "ID", nullable = false, unique = true)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;


    @Column(name = "StartDate")
    private Date startDate;

    @Column(name = "graduationDate")
    private Date graduationDate;

    @Column(name = "Test_num")
    private String testNum;

    @Column(name = "PIN_codes")
    private Long pINCodes;

    @Column(name = "Graduation_certificate_num")
    private Long Graduation_certificate_num;

    @Column(name = "Baccalaureate_NUM")
    private Long Baccalaureate_NUM;

    @OneToOne
    @JoinColumn(name = "student_Id")
    private Student student;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(Date graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getTestNum() {
        return testNum;
    }

    public void setTestNum(String testNum) {
        this.testNum = testNum;
    }

    public Long getpINCodes() {
        return pINCodes;
    }

    public void setpINCodes(Long pINCodes) {
        this.pINCodes = pINCodes;
    }

    public Long getGraduation_certificate_num() {
        return Graduation_certificate_num;
    }

    public void setGraduation_certificate_num(Long graduation_certificate_num) {
        Graduation_certificate_num = graduation_certificate_num;
    }

    public Long getBaccalaureate_NUM() {
        return Baccalaureate_NUM;
    }

    public void setBaccalaureate_NUM(Long baccalaureate_NUM) {
        Baccalaureate_NUM = baccalaureate_NUM;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
