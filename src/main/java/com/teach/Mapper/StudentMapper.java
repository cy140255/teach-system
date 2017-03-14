package com.teach.Mapper;

import com.teach.pojo.Student;
import org.apache.ibatis.annotations.Param;

import javax.ws.rs.QueryParam;

/**
 * Created by superfq on 2017/3/13.
 */
public interface StudentMapper {
    Student findStuddentById(@Param("userName") String userName, @Param("pwd")String pwd);


}
