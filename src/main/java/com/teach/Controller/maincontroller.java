package com.teach.Controller;

import com.teach.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.ws.rs.QueryParam;

/**
 * Created by superfq on 2017/3/10.
 */
@Controller
public class maincontroller {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/login.do",method = RequestMethod.GET)
    public String index(@QueryParam("userName")String userName,@QueryParam("pwd")String  pwd) {
            studentService.findStudentById(userName,pwd);
        return "index";
    }
}
