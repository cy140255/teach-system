package com.teach.Controller;

import com.teach.Dto.CourseListDto;
import com.teach.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.ws.rs.QueryParam;

import static java.util.Objects.nonNull;

/**
 * Created by 14025 on 2017/5/13.
 */
@Controller
public class SelectStudent {

    @Autowired
    private StudentService studentService;


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


@RequestMapping("/inset.do")
    public String insert(@QueryParam("teacherId")Long teacherId,
                         HttpSession session,
                         @QueryParam("studentId")Integer studentId,@QueryParam("courseId")Integer courseId,@QueryParam("score")Integer score){


    studentService.insert(studentId,courseId,score);

    CourseListDto selectStudent = studentService.selectStudent(teacherId,"","","","");
    session.setAttribute("selectStudent",selectStudent);
    return "teacher/selectStudent";
}


}
