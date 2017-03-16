package com.teach.Service;

import com.teach.Mapper.StudentMapper;
import com.teach.pojo.Student;
import com.util.dao.BaseDao;
import org.apache.poi.ss.usermodel.Workbook;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by superfq on 2017/3/10.
 */
@Service
@javax.transaction.Transactional
public class StudentService {
    @Resource
    StudentMapper studentMapper;

    private BaseDao baseDao  = new BaseDao();
    public Student findStudentById(String userName, String password)
     {
            Student student = studentMapper.findStuddentById(userName,password);

         return student;
    }


    public InputStream export(){
        TemplateExportParams params = new TemplateExportParams("export/业务明细.xls");


        Map<String, Object> map = new HashMap<String, Object>();
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        int num = 1;

            Map<String, Object> eachMap = new HashMap<String, Object>();
            eachMap.put("num", num);
            num++;
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
}
