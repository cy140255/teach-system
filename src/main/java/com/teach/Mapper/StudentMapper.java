package com.teach.Mapper;

import com.teach.pojo.Student;

import javax.ws.rs.QueryParam;

/**
 * Created by superfq on 2017/3/13.
 */
public interface StudentMapper {
    Student findStuddentById(@QueryParam("userName")String userName,@QueryParam("pwd")String pwd);


}
