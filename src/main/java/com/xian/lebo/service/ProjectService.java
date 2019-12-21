package com.xian.lebo.service;

import com.github.pagehelper.PageInfo;
import com.xian.lebo.pojo.Project;

import java.util.List;

public interface ProjectService {
    List<Integer> getProjectsById(int id);
    PageInfo<Project> getProjects(int indexPage, int pageSize);
    PageInfo<Project> getProjectsLike(int indexPage, int pageSize,String pname);
    int addProject(Project project);
    int deleteProject(int id);
    List<Project> getProjectsMult();
}
