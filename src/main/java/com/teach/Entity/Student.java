package com.teach.Entity;

import com.util.entity.AggregateRoot;

import javax.persistence.*;

/**
 * Created by superfq on 2017/3/14.
 */
@Entity
@Table(name = "STUDENT")
public class Student extends AggregateRoot {
    @Id
    @Column(name = "ID", nullable = false, unique = true)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sname")
    private String sname;

    @Column(name = "password")
    private String password;

    @Column(name = "id_num")
    private Long idNum;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getIdNum() {
        return idNum;
    }

    public void setIdNum(Long idNum) {
        this.idNum = idNum;
    }
}
