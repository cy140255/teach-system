package com.teach.Controller;

import com.teach.Dto.CourseDto;
import com.teach.Dto.CourseListDto;
import com.teach.Dto.StudentDto;
import com.teach.Dto.TeacherDto;
import com.teach.Entity.Student.Student;
import com.teach.Entity.Teacher.Teacher;
import com.teach.Mapper.StudentMapper;
import com.teach.Mapper.TeacherMapper;
import com.teach.Service.StudentService;
import com.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;
import javax.ws.rs.QueryParam;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;


/**
 * Created by 14025 on 2017/5/9.
 */
@SessionAttributes({"student","courseListDto","teacherDto","teacher"})

@Controller
public class LoginController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentMapper studentMapper;


    @Autowired
    private TeacherMapper teacherMapper;



    @RequestMapping(value = "/login.do",method = RequestMethod.GET)
    public String login(@QueryParam("Student_ID")Long studentId, @QueryParam("password")String password,Map<String,Object> map){
        Student student = studentMapper.findStudent(studentId,password);
        Teacher teacher = teacherMapper.findTeacher(studentId,password);
        if (nonNull(student)) {
            CourseListDto courseListDto = studentService.selectCourse(student.getId(), "","","","","");
            if (nonNull(student)) {
                map.put("student",student);
                map.put("courseListDto", courseListDto);
            }
            return "student/courses";

        }else if (nonNull(teacher)){
            TeacherDto teacherDto = studentService.teacherLogin(studentId,password);
            map.put("teacher",teacher);
            map.put("teacherDto", teacherDto);
            return "teacher/teacher";

        }else {

            return "login";

        }

    }
}
