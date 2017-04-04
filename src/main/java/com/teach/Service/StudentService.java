package com.teach.Service;

import com.teach.Mapper.StudentMapper;
import com.teach.Entity.Student;
import com.util.DateTimeUtil;
import com.util.dao.BaseDao;
import org.apache.poi.ss.usermodel.Workbook;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by superfq on 2017/3/10.
 */
@Service
@Transactional
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private BaseDao baseDao;
    public Student findStudentById(String userName, String password)
     {
         Student student = new Student();
         student.setSname(userName);
         student.setPassword(password);
         baseDao.persist(student);
         return student;
    }


    public InputStream export(){
        TemplateExportParams params = new TemplateExportParams("export/业务明细.xls");


        Map<String, Object> map = new HashMap<String, Object>();
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            Map<String, Object> eachMap = new HashMap<String, Object>();
            eachMap.put("num", 1);
            eachMap.put("customerName", "123");
            eachMap.put("requiredDate","123");
            eachMap.put("vesselVoyage", "123" + "/" + "123");
            eachMap.put("orderNumber", "123");
            eachMap.put("sizeTypeItem", "123");
            eachMap.put("orderStatus", "123");
            eachMap.put("containerRequirement", "123");
            eachMap.put("carrierName", "123");
            eachMap.put("remark", "123");
            eachMap.put("depot", "123");
            eachMap.put("dollarInOutCharge", "123");
            eachMap.put("serviceCharge", "123");
            eachMap.put("sumPrice", "123");
            eachMap.put("supplierName", "123");
            eachMap.put("userName","123");
            eachMap.put("orderBillStatusName", "123");
            eachMap.put("releaseDate", "123");
            eachMap.put("createTime", "123");
            list.add(eachMap);

        map.put("mapList", list);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        Date date = new Date();

        map.put("time", formatter.format(date));

        map.put("sumDollarInOutCharge", "123");
        map.put("sumServiceCharge", "123");

        map.put("SUM", "123");


        ByteArrayOutputStream output = new ByteArrayOutputStream();
        Workbook workbook = ExcelExportUtil.exportExcel(params, map);
        try {
            workbook.write(output);
//			workbook.write(new FileOutputStream(new File("d:/1.xls")));
        } catch (Exception e) {

        }

        return new ByteArrayInputStream(output.toByteArray());
    }
    public List<String> save(){
       List<Student> students= baseDao.findAll(Student.class);
       List<String> stringList = new ArrayList<>();
        for (Student student:students){
            stringList.add(changDate(student));
        }

        return stringList;
    }

    public String changDate(Student student){
        return DateTimeUtil.convertToDisplayDateTime(student.getCreationTime());

    }

}
