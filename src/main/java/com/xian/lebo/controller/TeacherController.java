package com.xian.lebo.controller;


import com.github.pagehelper.PageInfo;
import com.xian.lebo.pojo.Teacher;
import com.xian.lebo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/teacher")
@Controller
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping("/list")
    public String list(@RequestParam(name = "tname",defaultValue = "") String tname,
                       @RequestParam(name="indexPage",defaultValue = "1") int indexPage,
                       @RequestParam(name = "pageSize" ,defaultValue = "5") int pageSize,
                       Model model){
        PageInfo<Teacher> info;
        if(!tname.equals("")&&tname!=null){
            info = teacherService.getTeachersLike( indexPage,pageSize,tname);
        }
        else{
            info= teacherService.getTeachers(indexPage,pageSize);
        }
        model.addAttribute("info",info);
        model.addAttribute("tname",tname);
        return "teacherShow";
    }

    @GetMapping("/{id}")
    public String updateShow(@PathVariable("id") int id,Model model){
        Teacher teacher = teacherService.getTeacher(id);
        model.addAttribute("teacher",teacher);
        return "teacherUpdate";
    }

    @PostMapping("/update")
    @ResponseBody
    public String updateTeacher(Teacher teacher){
        String flag="0";
        try{
            teacherService.updateTeacherById(teacher);
            flag="1";
        }
        catch (Exception e){

        }
        return flag;
    }

    @GetMapping("/addShow")
    public String addTeacherShow(){
        return "teacherShowAdd";
    }

    @PostMapping("/add")
    @ResponseBody
    public String addTeacher(Teacher teacher)
    {
        String flag="0";
        try{
            teacherService.addTeacher(teacher);
            flag="1";
        }
        catch (Exception e){

        }
        return flag;
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deleteTeacher(@PathVariable("id") int id)
    {
        String flag="0";
        try {
            teacherService.deleteTeacher(id);
            flag="1";
        }
        catch (Exception e){

        }
        return flag;
    }
}
