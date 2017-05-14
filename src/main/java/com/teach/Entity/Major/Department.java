package com.teach.Entity.Major;

import com.teach.Entity.Student.Student;
import com.util.entity.AggregateRoot;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 14025 on 2017/5/8.
 */
@Entity
@Table(name = "Department") //院系
public class Department extends AggregateRoot{

    @Id
    @Column(name = "ID", nullable = false, unique = true)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;


    @Column(name = "Name")
    private String name; //名称


    @OneToMany
    @JoinColumn(name = "department_ID")
    private List<Major> majors = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "department_ID")
    private List<Student> studentList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }


    public List<Major> getMajors() {
        return majors;
    }

    public void setMajors(List<Major> majors) {
        this.majors = majors;
    }
}
