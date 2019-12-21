package com.xian.lebo.mapper;

import com.xian.lebo.pojo.Project;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProjectMapper {

    @Select("select id from project where id in (${ids})")
     List<Integer> getProjectsById(String ids);

    @Select("select * from project")
     List<Project> getProjects();

    @Select("select * from project where pname like '%${pname}%'")
     List<Project> getProjectsLike(String pname);

    @Insert("insert into project (`pname`)values(#{pname}) ")
    int addProject(Project project);

    @Delete("delete from project where id=#{id}")
    int deleteProject(int id);
}
