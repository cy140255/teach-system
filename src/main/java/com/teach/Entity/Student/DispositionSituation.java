package com.teach.Entity.Student;

import com.util.entity.AggregateRoot;

import javax.persistence.*;

/**
 * Created by 14025 on 2017/5/1.
 */
@Entity
@Table(name = "DispositionSituation")
public class DispositionSituation extends AggregateRoot {
    @Id
    @Column(name = "ID", nullable = false, unique = true)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dispositionDate")
    private String dispositionDate;//处分

    @Column(name = "dispositionName")
    private String dispositionName;

    @Column(name = "dispositionCompany")
    private String dispositionCompany;

    @Column(name = "dispositionReason")
    private String dispositionReason;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDispositionDate() {
        return dispositionDate;
    }

    public void setDispositionDate(String dispositionDate) {
        this.dispositionDate = dispositionDate;
    }

    public String getDispositionName() {
        return dispositionName;
    }

    public void setDispositionName(String dispositionName) {
        this.dispositionName = dispositionName;
    }

    public String getDispositionCompany() {
        return dispositionCompany;
    }

    public void setDispositionCompany(String dispositionCompany) {
        this.dispositionCompany = dispositionCompany;
    }

    public String getDispositionReason() {
        return dispositionReason;
    }

    public void setDispositionReason(String dispositionReason) {
        this.dispositionReason = dispositionReason;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
