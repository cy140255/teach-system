package com.teach.Service;

import com.teach.Mapper.StudentMapper;
import com.teach.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by superfq on 2017/3/10.
 */
@Service
@javax.transaction.Transactional
public class StudentService {
    @Resource
    StudentMapper studentMapper;

    public Student findStudentById(String userName, String password)
     {
        studentMapper.findStuddentById(userName,password);


        return null;
    }
}
