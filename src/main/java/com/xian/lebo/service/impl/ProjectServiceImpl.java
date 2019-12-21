package com.xian.lebo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xian.lebo.mapper.ProjectMapper;
import com.xian.lebo.pojo.Project;
import com.xian.lebo.pojo.Student;
import com.xian.lebo.service.ProjectService;
import com.xian.lebo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectMapper projectMapper;

    @Autowired
    StudentService studentService;


    @Override
    public List<Integer> getProjectsById(int id) {
        Student stu = studentService.getStudentById(id);
        String ids = stu.getProject();
        List<Integer> projects = projectMapper.getProjectsById(ids);
        return projects;
    }

    @Override
    public  PageInfo<Project> getProjects(int indexPage,int pageSize) {
        PageHelper.startPage(indexPage,pageSize);
        List<Project> list = projectMapper.getProjects();
        PageInfo<Project> info=new PageInfo<Project>(list);
        return info;
    }

    @Override
    public PageInfo<Project> getProjectsLike(int indexPage, int pageSize, String pname) {
        PageHelper.startPage(indexPage,pageSize);
        List<Project> list = projectMapper.getProjectsLike(pname);
        PageInfo<Project> info=new PageInfo<Project>(list);
        return info;
    }

    @Override
    public int addProject(Project project) {
        return projectMapper.addProject(project);
    }

    @Override
    public int deleteProject(int id) {
        return projectMapper.deleteProject(id);
    }

    @Override
    public List<Project> getProjectsMult() {
        return projectMapper.getProjects();
    }
}
