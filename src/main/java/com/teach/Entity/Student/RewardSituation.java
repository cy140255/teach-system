package com.teach.Entity.Student;

import com.util.entity.AggregateRoot;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by 14025 on 2017/5/1.
 */
@Entity
@Table(name = "RewardSituation")
public class RewardSituation extends AggregateRoot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = true,unique = true)
    private Long Id;

    @Column(name = "rewardDate")
    private String  rewardDate;

    @Column(name = "rewardName")
    private String rewardName;

    @Column(name = "rewardsCompany")
    private String rewardsCompany;

    @Column(name = "rewoadLevel")
    private String rewoadLevel;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getRewardDate() {
        return rewardDate;
    }

    public void setRewardDate(String rewardDate) {
        this.rewardDate = rewardDate;
    }

    public String getRewardName() {
        return rewardName;
    }

    public void setRewardName(String rewardName) {
        this.rewardName = rewardName;
    }

    public String getRewardsCompany() {
        return rewardsCompany;
    }

    public void setRewardsCompany(String rewardsCompany) {
        this.rewardsCompany = rewardsCompany;
    }

    public String getRewoadLevel() {
        return rewoadLevel;
    }

    public void setRewoadLevel(String rewoadLevel) {
        this.rewoadLevel = rewoadLevel;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
