package com.xian.lebo.controller;


import com.github.pagehelper.PageInfo;
import com.xian.lebo.mapper.StudentMapper;
import com.xian.lebo.mapper.TeacherMapper;
import com.xian.lebo.pojo.Classes;
import com.xian.lebo.pojo.Project;
import com.xian.lebo.pojo.StudentTest;
import com.xian.lebo.pojo.Teacher;
import com.xian.lebo.service.ClassesService;
import com.xian.lebo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/classes")
public class ClassesController {

    @Autowired
    ClassesService classesService;

    @Autowired
    TeacherMapper teacherMapper;

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    ProjectService projectService;

    @GetMapping("/list")
    public String list(@RequestParam(name="cname",defaultValue = "") String cname,
                       @RequestParam(name="tname",defaultValue = "") String tname,
                       @RequestParam(name="indexPage",defaultValue = "1") int indexPage,
                       @RequestParam(name = "pageSize" ,defaultValue = "5") int pageSize,
                       Model model){
        PageInfo<Classes> info;
        if(!cname.equals("")&&cname!=null){
            info = classesService.getClassesCnameLike(indexPage,pageSize,cname);
        }
        else if(!tname.equals("")&&tname!=null){
            info= classesService.getClassesTnameLike(indexPage,pageSize,tname);
        }
        else {
            info = classesService.getClasses(indexPage, pageSize);
        }
        model.addAttribute("info",info);
        model.addAttribute("cname",cname);
        model.addAttribute("tname",tname);
        return "classesShow";
    }

    @RequestMapping("/addShow")
    public String addShow(Model model){
        List<Teacher> teachers = teacherMapper.getTeachers();
        model.addAttribute("teachers",teachers);
        return "classesShowAdd";
    }


    @PostMapping("/add")
    @ResponseBody
    public String addProject(Classes classes){
        String flag="0";
        try {
            classesService.addClasses(classes);
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
            classesService.deleteClasses(id);
            flag="1";
        }
        catch (Exception e){

        }
        return flag;
    }

    @GetMapping("/{id}")
    public String updateShow(@PathVariable("id") int id,Model model){
        Classes classes = classesService.getClassesById(id);
        List<Teacher> teachers = teacherMapper.getTeachers();
        model.addAttribute("classes",classes);
        model.addAttribute("teachers",teachers);
        return "classesUpdate";
    }

    @PostMapping("/update")
    @ResponseBody
    public String updateTeacher(Classes classes){
        String flag="0";
        try{
            classesService.updateClassesById(classes);
            flag="1";
        }
        catch (Exception e){

        }
        return flag;
    }

    @GetMapping("/multPage/{id}")
    public String toMultPage(@PathVariable("id") int id,Model model){
        Classes classes = classesService.getClassesById(id);
        List<Project> projects = projectService.getProjectsMult();
        List<Teacher> teachers = teacherMapper.getTeachers();
        model.addAttribute("classes",classes);
        model.addAttribute("teachers",teachers);
        model.addAttribute("projects",projects);

        return "studentUpdateMult2";
    }


    @GetMapping("/findByClass")
    @ResponseBody
    public List<StudentTest> findByClass(@RequestParam("clsId") int clsId){
        List<StudentTest> list = studentMapper.getStudentByCid(clsId);
        return list;
    }

}
