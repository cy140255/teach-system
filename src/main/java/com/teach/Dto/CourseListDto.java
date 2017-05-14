package com.teach.Dto;

import com.teach.Entity.Courses.Course;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 14025 on 2017/5/10.
 */
public class CourseListDto {
    private List<CourseDto> professionalCourses = new ArrayList<>();
    private List<CourseDto> commonCourses = new ArrayList<>();
    private List<CourseDto> laboratoryCourses = new ArrayList<>();


    public List<CourseDto> getProfessionalCourses() {
        return professionalCourses;
    }

    public void setProfessionalCourses(List<CourseDto> professionalCourses) {
        this.professionalCourses = professionalCourses;
    }

    public List<CourseDto> getCommonCourses() {
        return commonCourses;
    }

    public void setCommonCourses(List<CourseDto> commonCourses) {
        this.commonCourses = commonCourses;
    }

    public List<CourseDto> getLaboratoryCourses() {
        return laboratoryCourses;
    }

    public void setLaboratoryCourses(List<CourseDto> laboratoryCourses) {
        this.laboratoryCourses = laboratoryCourses;
    }
}
