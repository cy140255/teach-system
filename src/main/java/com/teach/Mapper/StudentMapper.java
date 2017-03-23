package com.teach.Mapper;

import com.teach.Entity.Student;
import org.apache.ibatis.annotations.Param;

/**
 * Created by superfq on 2017/3/13.
 */
public interface StudentMapper {
    Student findStuddentById(@Param("userName") String userName, @Param("pwd")String pwd);
    void saveStudent(@Param("sname")String sname,@Param("password")String password);

}
