package com.teach.Controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.swing.*;
import javax.ws.rs.QueryParam;

/**
 * Created by superfq on 2017/3/10.
 */
@Controller
public class maincontroller {
    @RequestMapping(value = "/login.do",method = RequestMethod.POST)
    public String index(@QueryParam("username")String username,@QueryParam("password")String  password) {
       System.out.print(username);
        System.out.print(password);
        return "index";
    }
}
