package com.teach.Dto;

import com.teach.Entity.Student.*;

import java.util.List;

/**
 * Created by 14025 on 2017/5/9.
 */
public class StudentDto {
    private Long id;
    private Long studentId; //学号
    private String password; //密码
    private String departmentName;//院校
    private String majorName;//专业
    private StudentBaseInfo studentBaseInfo;//基础信息
    private List<StudentExperience> studentExperiences; //工作经验
    private List<StudentFamilyInfo> studentFamilyInfos;//家庭情况
    private List<StudentMajorChange> studentMajorChanges;//转换专业
    private List<DispositionSituation> dispositionSituations;//处分情况
    private List<RewardSituation> rewardSituations;//奖励情况
    private OtherInfo otherInfo;
    private String Score;
    private String studentName;
    private String clazz;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
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

    public List<DispositionSituation> getDispositionSituations() {
        return dispositionSituations;
    }

    public void setDispositionSituations(List<DispositionSituation> dispositionSituations) {
        this.dispositionSituations = dispositionSituations;
    }

    public List<RewardSituation> getRewardSituations() {
        return rewardSituations;
    }

    public void setRewardSituations(List<RewardSituation> rewardSituations) {
        this.rewardSituations = rewardSituations;
    }

    public OtherInfo getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(OtherInfo otherInfo) {
        this.otherInfo = otherInfo;
    }

    public String getScore() {
        return Score;
    }

    public void setScore(String score) {
        Score = score;
    }


    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }
}
