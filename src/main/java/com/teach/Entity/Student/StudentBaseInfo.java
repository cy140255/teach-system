package com.teach.Entity.Student;

import com.util.entity.AggregateRoot;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by 14025 on 2017/5/1.
 */
@Entity
@Table(name="studentBaseInfo")
public class StudentBaseInfo extends AggregateRoot {
    @Id
    @Column(name = "ID", nullable = false, unique = true)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sname")
    private String sname; //姓名



    @Column(name = "sname_CN")
    private String snameCN; //姓名简拼

    @Column(name = "Gender")
    private String gender; //性别

    @Column(name = "Birthday")
    private String birthday;//出生日期

    @Column(name = "isMarry")
    private String isMarry; //是否结婚

    @Column(name = "telPhoneNum")
    private Long telPhone; //电话号码

    @Column(name = "Political_outlook")
    private String PoliticalOutlook; //政治面貌

    @Column(name = "communistDate")
    private Date communistDate; //入团时间

    @Column(name = "native_place")
    private String nativePlace; //籍贯

    @Column(name = "national")
    private String national;//名族

    @Column(name = "Postcode")
    private long Postcode; //邮编

    @Column(name = "homeAddress")
    private String homeAddress; //家庭住址

    @Column(name = "hometelPhone")
    private String homeTelPhone; //家庭电话

    @Column(name = "clazz")
    private String clazz; //班级 计科1302

    @Column(name = "grade")
    private String grade; //年级 13级

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;
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

    public String getSnameCN() {
        return snameCN;
    }

    public void setSnameCN(String snameCN) {
        this.snameCN = snameCN;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIsMarry() {
        return isMarry;
    }

    public void setIsMarry(String isMarry) {
        this.isMarry = isMarry;
    }

    public Long getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(Long telPhone) {
        this.telPhone = telPhone;
    }

    public String getPoliticalOutlook() {
        return PoliticalOutlook;
    }

    public void setPoliticalOutlook(String politicalOutlook) {
        PoliticalOutlook = politicalOutlook;
    }

    public Date getCommunistDate() {
        return communistDate;
    }

    public void setCommunistDate(Date communistDate) {
        this.communistDate = communistDate;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public long getPostcode() {
        return Postcode;
    }

    public void setPostcode(long postcode) {
        Postcode = postcode;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getHomeTelPhone() {
        return homeTelPhone;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public void setHomeTelPhone(String homeTelPhone) {
        this.homeTelPhone = homeTelPhone;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
