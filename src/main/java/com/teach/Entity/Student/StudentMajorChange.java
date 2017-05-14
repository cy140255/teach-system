package com.teach.Entity.Student;

import com.util.entity.AggregateRoot;

import javax.persistence.*;

/**
 * Created by 14025 on 2017/5/1.
 */
@Entity
@Table(name = "StudentMajorChange")
public class StudentMajorChange extends AggregateRoot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = true,unique = true)
    private Long id;

    @Column(name = "transactionType")
    private String transactionType;

    @Column(name = "TransactionReason")
    private String transactionReason;

    @Column(name = "TransactionDate")
    private String transactionDate;

    @Column(name = "Original_Department")
    private String originalDepartment;

    @Column(name = "Original_Major")
    private String originalMajor;

    @Column(name = "Original_class")
    private String originalClass;


    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionReason() {
        return transactionReason;
    }

    public void setTransactionReason(String transactionReason) {
        this.transactionReason = transactionReason;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getOriginalDepartment() {
        return originalDepartment;
    }

    public void setOriginalDepartment(String originalDepartment) {
        this.originalDepartment = originalDepartment;
    }

    public String getOriginalMajor() {
        return originalMajor;
    }

    public void setOriginalMajor(String originalMajor) {
        this.originalMajor = originalMajor;
    }

    public String getOriginalClass() {
        return originalClass;
    }

    public void setOriginalClass(String originalClass) {
        this.originalClass = originalClass;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
