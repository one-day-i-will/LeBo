package com.xian.lebo.controller;

import com.github.pagehelper.PageInfo;
import com.xian.lebo.pojo.Project;
import com.xian.lebo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping("/list")
    public String list(@RequestParam(name="pname",defaultValue = "") String pname,
                        @RequestParam(name="indexPage",defaultValue = "1") int indexPage,
                       @RequestParam(name = "pageSize" ,defaultValue = "5") int pageSize,
                       Model model){
        PageInfo<Project> info;
        if(!pname.equals("")&&pname!=null){
            info = projectService.getProjectsLike( indexPage,pageSize,pname);
        }
        else{
            info= projectService.getProjects(indexPage,pageSize);
        }
        model.addAttribute("info",info);
        model.addAttribute("pname",pname);
        return "projectShow";
    }

    @PostMapping("/add")
    @ResponseBody
    public String addProject(Project project){
        String flag="0";
        try {
            projectService.addProject(project);
            flag="1";
        }
        catch (Exception e){

        }
        return flag;
    }


    @RequestMapping("/addShow")
    public String addShow(){
        return "projectShowAdd";
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deleteProject(@PathVariable("id") int id){
        String flag="0";
        try {
            projectService.deleteProject(id);
            flag="1";
        }
        catch (Exception e){

        }
        return flag;
    }
}
