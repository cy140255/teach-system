package com.teach.Entity.Student;

import com.teach.Entity.Courses.Course;
import com.teach.Entity.Major.Department;
import com.teach.Entity.Major.Major;
import com.teach.Entity.Teacher.Teacher;
import com.util.entity.AggregateRoot;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "Student_ID")
    private Long studentID; //学号

    @Column(name = "password")
    private String password;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private List<DispositionSituation> dispositionSituations = new ArrayList<>();

    @OneToOne(mappedBy = "student")
    @JoinColumn(name = "student_id")
    private OtherInfo otherInfo;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private List<RewardSituation> rewardSituations = new ArrayList<>();

    @OneToOne(mappedBy = "student",fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private StudentBaseInfo studentBaseInfo ;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private List<StudentExperience> studentExperiences  =new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private List<StudentFamilyInfo> studentFamilyInfos =new ArrayList<>();


    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private List<StudentMajorChange> studentMajorChanges =new ArrayList<>();

   @OneToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "department_ID")
   private Department department;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "major_id")
    private Major  major;



    @ManyToMany(mappedBy = "students")
    private List<Course> courses = new ArrayList<>();

    @ManyToMany(mappedBy = "studentList")
    private List<Teacher> teacherList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentID() {
        return studentID;
    }

    public void setStudentID(Long studentID) {
        this.studentID = studentID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<DispositionSituation> getDispositionSituations() {
        return dispositionSituations;
    }

    public void setDispositionSituations(List<DispositionSituation> dispositionSituations) {
        this.dispositionSituations = dispositionSituations;
    }

    public OtherInfo getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(OtherInfo otherInfo) {
        this.otherInfo = otherInfo;
    }

    public List<RewardSituation> getRewardSituations() {
        return rewardSituations;
    }

    public void setRewardSituations(List<RewardSituation> rewardSituations) {
        this.rewardSituations = rewardSituations;
    }

    public StudentBaseInfo getStudentBaseInfo() {
        return studentBaseInfo;
    }

    public void setStudentBaseInfo(StudentBaseInfo studentBaseInfo) {
        this.studentBaseInfo = studentBaseInfo;
    }

    public List<StudentExperience> getStudentExperiences() {
        return studentExperiences;
    }

    public void setStudentExperiences(List<StudentExperience> studentExperiences) {
        this.studentExperiences = studentExperiences;
    }

    public List<StudentFamilyInfo> getStudentFamilyInfos() {
        return studentFamilyInfos;
    }

    public void setStudentFamilyInfos(List<StudentFamilyInfo> studentFamilyInfos) {
        this.studentFamilyInfos = studentFamilyInfos;
    }

    public List<StudentMajorChange> getStudentMajorChanges() {
        return studentMajorChanges;
    }

    public void setStudentMajorChanges(List<StudentMajorChange> studentMajorChanges) {
        this.studentMajorChanges = studentMajorChanges;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }


    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }


}
