package com.teach.Controller;

import com.teach.Service.StudentService;
import com.teach.pojo.Student;
import com.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
/**
 * Created by superfq on 2017/3/10.
 */
@Controller
public class maincontroller {
    @Context
    protected HttpServletRequest req;

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/login.do",method = RequestMethod.GET)
    public String index(@QueryParam("userName")String userName,@QueryParam("pwd")String  pwd) {
        Student student = studentService.findStudentById(userName,pwd);
        if (isNull(student)){
            return "asda";
        }
        return "index";
    }


    @RequestMapping(value = "/export.do",method = RequestMethod.GET)
    public void export(HttpServletResponse response) throws Exception{

        String fileName = HttpUtil.encodeDownloadFileName(req, "放箱列表" + "-" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) + ".xls");
        InputStream inputStream = studentService.export();
        response.addHeader("Content-Disposition","attachment; filename=" + fileName);
        response.setContentType("mutipart/form-data");
        BufferedOutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
        int len = 0;
        while ((len =inputStream.read())!= -1){
            outputStream.write(len);
            outputStream.flush();
        }
       outputStream.close();
    }
}
