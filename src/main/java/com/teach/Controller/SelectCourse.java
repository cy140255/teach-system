package com.teach.Controller;

import com.teach.Dto.CourseListDto;
import com.teach.Dto.TeacherDto;
import com.teach.Entity.Student.Student;
import com.teach.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import javax.ws.rs.QueryParam;
import java.util.Map;

import static java.util.Objects.nonNull;
import static java.util.Objects.isNull;

/**
 * Created by 14025 on 2017/5/10.
 */

@Controller
public class SelectCourse {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/select.do",method = RequestMethod.GET)
    public String select(Map<String,Object> map,
                         @QueryParam("id")Long id,
                         @QueryParam("courseStartDate")String courseStartDate,
                         @QueryParam("courseName")String courseName,
                         @QueryParam("assessment_Methods")String assessment_Methods,
                         @QueryParam("curriculumNature")String curriculumNature,
                         @QueryParam("temp")String temp,
                         @QueryParam("index")String index,
                         HttpSession session){
        session.removeAttribute("courseListDto");
        CourseListDto courseListDto= studentService.selectCourse(id,courseStartDate,courseName,assessment_Methods,curriculumNature,temp,index);
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setCourseListDto(courseListDto);
        session.setAttribute("teacherDto",teacherDto);
        session.setAttribute("courseListDto",courseListDto);
        if (nonNull(temp)&&temp.equals("teacher")&&isNull(index)){

            return "teacher/course";
        }else if (nonNull(temp)&&temp.equals("test")&&isNull(index)){
            return "student/test";
        }if (nonNull(temp)&&temp.equals("graduationProject")&&isNull(index)){
            return "student/graduationProject";
        }else if (nonNull(index)&&index.equals("invigilator")){
            return "teacher/test";
        }else if (nonNull(temp)&&temp.equals("admin")&&isNull(index)){
            return "admin/selectCourse";
        }

        return "course/course";
    }
}
