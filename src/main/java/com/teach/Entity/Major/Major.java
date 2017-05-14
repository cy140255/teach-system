package com.teach.Entity.Major;

import com.teach.Entity.Student.Student;

import javax.persistence.*;

/**
 * Created by 14025 on 2017/5/8.
 */
@Entity
@Table(name = "Major")
public class Major {

    @Id
    @Column(name = "ID", nullable = false, unique = true)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;


    @Column(name = "name")
    private String  name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_ID")
    private Department department;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "major_id")
    private Student student;




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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
