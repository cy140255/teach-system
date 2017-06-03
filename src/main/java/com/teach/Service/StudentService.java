package com.teach.Service;

import com.teach.Dto.CourseDto;
import com.teach.Dto.CourseListDto;
import com.teach.Dto.StudentDto;
import com.teach.Dto.TeacherDto;
import com.teach.Entity.Courses.Course;
import com.teach.Entity.Major.Department;
import com.teach.Entity.Student.Score;
import com.teach.Entity.Teacher.Teacher;
import com.teach.Mapper.StudentMapper;
import com.teach.Entity.Student.Student;
import com.teach.Mapper.TeacherMapper;
import com.util.DateTimeUtil;
import com.util.dao.BaseDao;
import org.apache.poi.ss.usermodel.Workbook;
import org.hibernate.type.LongType;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.servlet.ServletContext;
import javax.transaction.Transactional;
import javax.ws.rs.QueryParam;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * Created by superfq on 2017/3/10.
 */
@Service
@Transactional
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;


    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private BaseDao baseDao;
    public void findStudentById(String userName, String password)
     {
         Student student = studentMapper.findStuddentById("zz","ok");
         
         student =baseDao.findById(Student.class,student.getId());
        Department department = student.getDepartment();
       List<Student> students=  department.getStudentList();
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

    public StudentDto studentLogin(Long studentId, String password){
        StudentDto studentDto = new StudentDto();
        Student student = studentMapper.findStudent(studentId,password);
        student = baseDao.findById(Student.class,student.getId());
        if (nonNull(student)){
            studentDto.setId(student.getId());
            studentDto.setPassword(student.getPassword());
            studentDto.setStudentId(student.getStudentID());
        }
        if (nonNull(student.getDepartment())){
            studentDto.setDepartmentName(student.getDepartment().getName());
            studentDto.setMajorName(student.getMajor().getName());
        }

        if (nonNull(student.getStudentBaseInfo())){
            studentDto.setStudentBaseInfo(student.getStudentBaseInfo());
        }
        if (student.getDispositionSituations().size()>=1){
            studentDto.setDispositionSituations(student.getDispositionSituations());
        }
        if (student.getRewardSituations().size()>=1){
            studentDto.setRewardSituations(student.getRewardSituations());
        }
        if (student.getStudentFamilyInfos().size()>=1){
            studentDto.setStudentFamilyInfos(student.getStudentFamilyInfos());
        }
        if (student.getStudentExperiences().size()>=1){
            studentDto.setStudentExperiences(student.getStudentExperiences());
        }
        if (student.getStudentMajorChanges().size()>=1){
            studentDto.setStudentMajorChanges(student.getStudentMajorChanges());
        }

        if (nonNull(student.getOtherInfo())){
            studentDto.setOtherInfo(student.getOtherInfo());
        }
        return studentDto;
    }




    public TeacherDto teacherLogin(Long id,String password){
        TeacherDto teacherDto = new TeacherDto();
        CourseListDto courseListDto = new CourseListDto();
        Teacher teacher =teacherMapper.findTeacher(id,password);
        teacher = baseDao.findById(Teacher.class,teacher.getId());
        List<Student> studentList= teacher.getStudentList();
        teacherDto.setStudentList(studentList);
        teacherDto.setTeacherName(teacher.getTeacherName());


        List<CourseDto> courses = teacherMapper.courses(teacher.getId(),"","","","");
        if (nonNull(courses)){
            List<CourseDto> professionalCourses =courses.stream().filter(t ->t.getCourseCategory().equals("专业基础")).collect(Collectors.toList());
            List<CourseDto> commonCourses = courses.stream().filter(t ->t.getCourseCategory().equals("通识课")).collect(Collectors.toList());
            List<CourseDto> laboratoryCourses = courses.stream().filter( t ->t.getCourseCategory().equals("实践环节")).collect(Collectors.toList());

            courseListDto.setLaboratoryCourses(laboratoryCourses);
            courseListDto.setCommonCourses(commonCourses);
            courseListDto.setProfessionalCourses(professionalCourses);

        }
        teacherDto.setCourseListDto(courseListDto);

        return teacherDto;
    }
    public CourseListDto selectCourse(Long id, String courseStartDate, String courseName, String assessment_Methods, String curriculumNature,String temp,String index){
        CourseListDto responseDto = new CourseListDto();
        if (nonNull(courseStartDate)){
            courseStartDate= courseStartDate.trim();
        }
        List<CourseDto> courses = new ArrayList<>();

        if (nonNull(temp)&&temp.equals("teacher")){
            courses = teacherMapper.courses(id,courseStartDate,courseName,assessment_Methods,curriculumNature);
        }else if (nonNull(temp)&&temp.equals("admin")){

            courses=teacherMapper.findAllCourses(courseStartDate,courseName,assessment_Methods,curriculumNature);
        }else {
            courses = studentMapper.courses(id,courseStartDate,courseName,assessment_Methods,curriculumNature);
        }


        if (nonNull(courses)&&isNull(index)){
           List<CourseDto> professionalCourses =courses.stream().filter(t ->t.getCourseCategory().equals("专业基础")).map(t ->getScore(t,id)).collect(Collectors.toList());
           List<CourseDto> commonCourses = courses.stream().filter(t ->t.getCourseCategory().equals("通识课")).map(t ->getScore(t,id)).collect(Collectors.toList());
           List<CourseDto> laboratoryCourses = courses.stream().filter( t ->t.getCourseCategory().equals("实践环节")).map(t ->getScore(t,id)).collect(Collectors.toList());
           List<CourseDto> graduationCourse = courses.stream().filter( t ->t.getCourseCategory().equals("毕业设计")).map(t ->getScore(t,id)).collect(Collectors.toList());

           responseDto.setLaboratoryCourses(laboratoryCourses);
           responseDto.setCommonCourses(commonCourses);
           responseDto.setProfessionalCourses(professionalCourses);
           responseDto.setGraduationCourse(graduationCourse);

        }else if (nonNull(index)&&"invigilator".equals(index)){
            Teacher teacher = baseDao.findById(Teacher.class,id);
            List<CourseDto> professionalCourses =courses.stream().filter(t ->nonNull(t.getTeacherName())&&t.getTeacherName().equals(teacher.getTeacherName())).filter(t ->t.getCourseCategory().equals("专业基础")).map(t ->getScore(t,id)).collect(Collectors.toList());
            List<CourseDto> commonCourses = courses.stream().filter(t ->nonNull(t.getTeacherName())&&t.getTeacherName().equals(teacher.getTeacherName())).filter(t ->t.getCourseCategory().equals("通识课")).map(t ->getScore(t,id)).collect(Collectors.toList());
            List<CourseDto> laboratoryCourses = courses.stream().filter(t ->nonNull(t.getTeacherName())&&t.getTeacherName().equals(teacher.getTeacherName())).filter( t ->t.getCourseCategory().equals("实践环节")).map(t ->getScore(t,id)).collect(Collectors.toList());

            responseDto.setLaboratoryCourses(laboratoryCourses);
            responseDto.setCommonCourses(commonCourses);
            responseDto.setProfessionalCourses(professionalCourses);
        }
        return responseDto;
    }

    private CourseDto getScore(CourseDto courseDto,Long id){
        courseDto.setScore(studentMapper.getScore(courseDto.getId(),id));
        return courseDto;
    }

        public CourseListDto selectStudent(Long id ,String grade,String studentName,String majorName,String departmentName){
            CourseListDto responseDto = new CourseListDto();

            Teacher teacher = baseDao.findById(Teacher.class,id);
            List<Course> courseList= teacher.getCourseList();
            List<CourseDto> professionalCourses =courseList.stream().filter(t ->t.getCourseCategory().equals("专业基础")).map(t ->changeEntityToDto(t,grade,studentName,majorName,departmentName)).map(t ->getStudentScore(t)).collect(Collectors.toList());
            List<CourseDto> commonCourses = courseList.stream().filter(t ->t.getCourseCategory().equals("通识课")).map(t ->changeEntityToDto(t,grade,studentName,majorName,departmentName)).map(t ->getStudentScore(t)).collect(Collectors.toList());
            List<CourseDto> laboratoryCourses = courseList.stream().filter( t ->t.getCourseCategory().equals("实践环节")).map(t ->changeEntityToDto(t,grade,studentName,majorName,departmentName)).map(t ->getStudentScore(t)).collect(Collectors.toList());
            responseDto.setLaboratoryCourses(laboratoryCourses);
            responseDto.setCommonCourses(commonCourses);
            responseDto.setProfessionalCourses(professionalCourses);
            return responseDto;
    }
        private CourseDto getStudentScore(CourseDto courseDto){
               List<Student> studentList = courseDto.getStudentList();
            List<StudentDto> studentDtoList;
               if (isNull(courseDto.getStudentDtoList())){
                    studentDtoList =new ArrayList<>();
               }else {
                    studentDtoList = courseDto.getStudentDtoList();
               }

                for (Student s:studentList) {
                    String score = studentMapper.getScore(courseDto.getId(),s.getId());
                    if (isNull(score)){
                        score = "暂无成绩";
                    }
                    StudentDto studentDto = new StudentDto();
                    studentDto.setScore(score);
                    studentDto.setId(s.getId());
                    studentDto.setStudentName(s.getStudentBaseInfo().getSname());
                    studentDto.setMajorName(s.getMajor().getName());
                    studentDto.setDepartmentName(s.getDepartment().getName());
                    studentDto.setClazz(s.getStudentBaseInfo().getClazz());
                    studentDtoList.add(studentDto);
                }
                courseDto.setStudentDtoList(studentDtoList);
                return courseDto;
        }

    private CourseDto changeEntityToDto(Course course,String grade,String studentName,String majorName,String departmentName){
            CourseDto courseDto = new CourseDto();
            courseDto.setId(course.getId());
            courseDto.setCourseName(course.getCourseName());
            courseDto.setCredit(course.getCredit());
            courseDto.setClassRoom(course.getClassroom());
            SimpleDateFormat  formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


            Date date = new Date();
            courseDto.setTestTime(formatter.format(date));
            courseDto.setStudyTime(course.getStudyTime());
            List<Student> studentList = course.getStudents().stream()
                    .filter(t -> nonNull(grade)&&!grade.equals("")?t.getStudentBaseInfo().getGrade().equals(grade):true)
                    .filter(t -> nonNull(studentName)&&!studentName.equals("")?t.getStudentBaseInfo().getSname().equals(studentName):true)
                    .filter(t -> nonNull(majorName)&&!majorName.equals("")?t.getMajor().getName().equals(majorName):true)
                    .filter(t ->nonNull(departmentName)&&!departmentName.equals("")?t.getDepartment().getName().equals(departmentName):true)
                    .collect(Collectors.toList());
            courseDto.setStudentList(studentList);
            return  courseDto;
    }



    public void changeScore(Integer studentId,Integer courseId,Integer scoreNum){
        Score score = teacherMapper.getScore(studentId,courseId);
        teacherMapper.upScore(scoreNum,score.getId());

    }
    public void insert(Integer studentId,Integer courseId,Integer scoreNum){

        Score score = teacherMapper.getScore(studentId,courseId);
        if (isNull(score)){
             score = new Score();
            score.setCourseId(courseId);
            score.setStudentId(studentId);
            score.setScoreNum(scoreNum);
            baseDao.persist(score);
        }else {
            teacherMapper.upScore(scoreNum,score.getId());
        }
    }


    public void addCourse(BigDecimal credit,
                          String curriculumNature,
                          String courseCategory,
                          String studyTime,
                          String courseStartDate,
                          String classroom,
                          String clazz,
                          String teacherName,
                          String courseName,
                          String grade,
                          Integer period){
        Course course = new Course();
        course.setStudyTime(studyTime);
        course.setStudyClassRoom(classroom);
        course.setCourseName(courseName);
        course.setCredit(credit);
        course.setCourseStartDate(courseStartDate);
        course.setCurriculumNature(curriculumNature);
        course.setCourseCategory(courseCategory);
        course.setPeriod(period);
        List<Student> studentList = baseDao.findAll(Student.class);
        studentList = studentList.stream().filter(t ->t.getStudentBaseInfo().getGrade().equals(grade)).filter(t ->t.getMajor().getName().equals(clazz)).collect(Collectors.toList());
         course.setStudents(studentList);
         List<Teacher> teachers = baseDao.findAll(Teacher.class);
         teachers= teachers.stream().filter(t ->t.getTeacherName().equals(teacherName)).collect(Collectors.toList());


         baseDao.persist(course);
        course.setTeacherList(teachers);


    }


    public void changeTest(String select,Long courseId,String score){

        if (select.equals("tesTime")){
            teacherMapper.upTesTime(score,courseId);
        }
        if (select.equals("classRoom")){
            teacherMapper.upClassrom(score,courseId);
        }
        if (select.equals("teacherName")){
            teacherMapper.upTeacherName(score,courseId);
        }

    }
}
