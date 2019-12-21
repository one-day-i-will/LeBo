package com.xian.lebo.controller;

import com.github.pagehelper.PageInfo;
import com.xian.lebo.mapper.ClassesMapper;
import com.xian.lebo.mapper.ProjectMapper;
import com.xian.lebo.mapper.TeacherMapper;
import com.xian.lebo.pojo.*;
import com.xian.lebo.service.ProjectService;
import com.xian.lebo.service.StudentService;
import com.xian.lebo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    ProjectService projectService;

    @Autowired
    ProjectMapper projectMapper;

    @Autowired
    TeacherMapper teacherMapper;

    @Autowired
    TeacherService teacherService;

    @Autowired
    ClassesMapper classesMapper;

    @GetMapping("/list")
    public String list(@RequestParam(name = "sname",defaultValue = "") String sname,
                       @RequestParam(name="indexPage",defaultValue = "1") int indexPage,
                       @RequestParam(name = "pageSize" ,defaultValue = "5") int pageSize,
                       Model model){
        PageInfo<Student> info;
        if(!sname.equals("")&&sname!=null){
            info = studentService.getStudentsLike( indexPage,pageSize,sname);
        }
        else{
            info= studentService.getStudents(indexPage,pageSize);
        }
       model.addAttribute("info",info);
        model.addAttribute("sname",sname);
        return "index";
    }

    @RequestMapping("/{id}")
    public String listStudent(@PathVariable(name="id") int id, Model model){
        Student stu = studentService.getStudentById(id);
       List<Integer> pids = projectService.getProjectsById(id);
        List<Project> projects = projectMapper.getProjects();
        List<Classes> classes = classesMapper.getAllClasses();
        model.addAttribute("stu",stu);
        model.addAttribute("pids",pids);
        model.addAttribute("projects",projects);
        model.addAttribute("classes",classes);
        return "studentShow";
    }

    @PostMapping("/update")
    @ResponseBody
    public String updateStudent(Student student)
    {
        String flag="0";
        try {
            int i=studentService.updateStudent(student);
            flag="1";
        } catch (Exception e) {
        }
        return flag;
    }

    @GetMapping("/updateId")
    public String showUpdate(Integer id,Model model){
        Student stu = studentService.getStudentById(id);
        List<Project> projects = projectMapper.getProjects();
        List<Teacher> teachers = teacherMapper.getTeachers();
        model.addAttribute("stu",stu);
        model.addAttribute("projects",projects);
        model.addAttribute("teachers",teachers);
        return "studentUpdate";
    }

    @GetMapping("/addShow")
    public String addShow(Model model){
        List<Project> projects = projectMapper.getProjects();
        List<Classes> classes = classesMapper.getAllClasses();
        model.addAttribute("projects",projects);
        model.addAttribute("classes",classes);
        return "studentShowAdd";
    }

    @PostMapping("/add")
    @ResponseBody
    public String addStudent(Student student){
        String flag="0";
        try {
            studentService.addStudent(student);
            flag="1";
        }
        catch (Exception e){

        }
       return flag;
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deleteStudent(@PathVariable("id") int id)
    {
        String flag="0";
        try {
            studentService.deleteStudent(id);
            flag="1";
        }
        catch (Exception e){

        }
        return flag;
    }

    @GetMapping("/multPage")
    public String toTestHtml(Model model){
        List<Project> projectsMult = projectService.getProjectsMult();
        List<Teacher> teachersMult = teacherService.getTeachersMult();
        model.addAttribute("teachers",teachersMult);
        model.addAttribute("projects",projectsMult);
        return "studentUpdateMult";
    }

    @GetMapping("/findByName")
    @ResponseBody
    public List<StudentTest> getData(@RequestParam(name = "name",defaultValue = "") String name){
        List<StudentTest> data = studentService.getData(name);
        return data;
    }

    @PostMapping("/multData")
    @ResponseBody
    public String studentMult(TimeTable timeTable, @RequestParam(name = "sid",defaultValue ="0") int[] sid){
        String flag="0";
        try {
            studentService.studentMult(sid,timeTable);
            flag="1";
        }catch (Exception e){
        }
      return flag;
    }
}
