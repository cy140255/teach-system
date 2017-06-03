package com.teach.Entity.Admin;

import com.util.entity.AggregateRoot;

import javax.persistence.*;

/**
 * Created by 14025 on 2017/5/16.
 */

@Entity
@Table(name = "Admin")
public class Admin extends AggregateRoot{
    @Id
    @Column(name = "ID", nullable = false, unique = true)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;



    @Column(name = "adminName")
    private String adminName;

    @Column(name = "password")
    private String password;


    @Column(name = "adminId")
    private Long adminId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }
}
