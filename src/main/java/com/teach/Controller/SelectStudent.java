package com.teach.Controller;

import com.teach.Dto.CourseListDto;
import com.teach.Dto.StudentDto;
import com.teach.Dto.TeacherDto;
import com.teach.Entity.Student.Student;
import com.teach.Service.StudentService;
import com.util.dao.BaseDao;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.ws.rs.QueryParam;

import java.math.BigDecimal;

import static java.util.Objects.nonNull;

/**
 * Created by 14025 on 2017/5/13.
 */
@Controller
public class SelectStudent {

    @Autowired
    private StudentService studentService;

    @Autowired
    private BaseDao baseDao;

    @RequestMapping("/selectStudent.do")
    public String selectStudent(HttpSession session,
                                @QueryParam("id")Long id,
                                @QueryParam("grade")String grade,
                                @QueryParam("studentName")String studentName,
                                @QueryParam("major")String majorName,
                                @QueryParam("departmentName")String departmentName){
        if (nonNull(grade)){
            grade = grade.trim();
        }
        CourseListDto selectStudent = studentService.selectStudent(id,grade,studentName,majorName,departmentName);
        session.setAttribute("selectStudent",selectStudent);
        return "teacher/selectStudent";
    }


@RequestMapping("/changeScore.do")
    public String changeScore(@QueryParam("teacherId")Long teacherId,
                              HttpSession session,
                              @QueryParam("studentId")Integer studentId,@QueryParam("courseId")Integer courseId,@QueryParam("score")Integer score){
            studentService.changeScore(studentId,courseId,score);
    CourseListDto selectStudent = studentService.selectStudent(teacherId,"","","","");
    session.setAttribute("selectStudent",selectStudent);
    return "teacher/selectStudent";

}


@RequestMapping(value = "/inset.do",method = RequestMethod.GET)
    public String insert(@QueryParam("teacherId")Long teacherId,
                         HttpSession session,
                         @QueryParam("studentId")Integer studentId,
                         @QueryParam("courseId")Integer courseId,
                         @QueryParam("score")Integer score){


    studentService.insert(studentId,courseId,score);

    CourseListDto selectStudent = studentService.selectStudent(teacherId,"","","","");
    session.setAttribute("selectStudent",selectStudent);
    return "teacher/selectStudent";
}


   @RequestMapping("/findStudent.do")
    public String findStudent(HttpSession session,
                              @QueryParam("studentId")Long studentId){
        Student student= baseDao.findById(Student.class,studentId);
        StudentDto studentDto= studentService.studentLogin(student.getStudentID(),student.getPassword());
        session.setAttribute("student",studentDto);
        return "student/学籍卡片";


}


    @RequestMapping(value = "/addCourse.do",method = RequestMethod.POST)
    public String addCourse(@QueryParam("credit")BigDecimal credit,
                            @QueryParam("curriculumNature")String curriculumNature,
                            @QueryParam("courseCategory")String courseCategory,
                            @QueryParam("studyTime")String studyTime,
                            @QueryParam("courseStartDate")String courseStartDate,
                            @QueryParam("classroom")String classroom,
                            @QueryParam("clazz")String clazz,
                            @QueryParam("teacherName")String teacherName,
                            @QueryParam("courseName")String courseName,
                            @QueryParam("grade")String grade,
                            @QueryParam("period")Integer period,
                            HttpSession session){
        studentService.addCourse(credit,curriculumNature,courseCategory,studyTime,courseStartDate,classroom,clazz,teacherName,courseName,grade,period);
        CourseListDto courseListDto= studentService.selectCourse(null,null,null,null,null,null,null);
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setCourseListDto(courseListDto);
        session.setAttribute("teacherDto",teacherDto);
        session.setAttribute("courseListDto",courseListDto);
        return "admin/selectCourse";
    }




    @RequestMapping("selectTest.do")
    public String selectTest(HttpSession session){
        CourseListDto courseListDto= studentService.selectCourse(null,null,null,null,null,"teacher",null);
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setCourseListDto(courseListDto);
        session.setAttribute("teacherDto",teacherDto);
        session.setAttribute("courseListDto",courseListDto);
        return "admin/test";
    }



    @RequestMapping("changeTest.do")
    public String changeTest(HttpSession session,
                             @QueryParam("select")String select,
                             @QueryParam("courseId")Long courseId,
                             @QueryParam("score")String score){

        studentService.changeTest(select,courseId,score);

        CourseListDto courseListDto= studentService.selectCourse(null,null,null,null,null,"teacher",null);
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setCourseListDto(courseListDto);
        session.setAttribute("teacherDto",teacherDto);
        session.setAttribute("courseListDto",courseListDto);
        return "admin/test";
    }
}
