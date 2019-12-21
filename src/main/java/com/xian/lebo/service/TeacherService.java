package com.xian.lebo.service;

import com.github.pagehelper.PageInfo;
import com.xian.lebo.pojo.Teacher;

import java.util.List;

public interface TeacherService {
    PageInfo<Teacher> getTeachers(int pageIndex, int pageSize);

    PageInfo<Teacher> getTeachersLike(int pageIndex, int pageSize, String sname);

    Teacher getTeacher(int id);

    int updateTeacherById(Teacher teacher);

    int addTeacher(Teacher teacher);

    int deleteTeacher(int id);

    List<Teacher> getTeachersMult();
}
