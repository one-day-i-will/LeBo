package com.xian.lebo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xian.lebo.mapper.TeacherMapper;
import com.xian.lebo.pojo.Teacher;
import com.xian.lebo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherMapper teacherMapper;


    @Override
    public PageInfo<Teacher> getTeachers(int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        List<Teacher> list = teacherMapper.getTeachers();
        PageInfo<Teacher> info=new PageInfo<Teacher>(list);
        return info;
    }

    @Override
    public PageInfo<Teacher> getTeachersLike(int pageIndex, int pageSize, String tname) {
        PageHelper.startPage(pageIndex,pageSize);
        List<Teacher> list = teacherMapper.getTeachersLike(tname);
        PageInfo<Teacher> info=new PageInfo<Teacher>(list);
        return info;
    }

    @Override
    public Teacher getTeacher(int id) {
        return teacherMapper.getTeacher(id);
    }

    @Override
    public int updateTeacherById(Teacher teacher) {
        return teacherMapper.updateTeacherById(teacher);
    }


    @Override
    public int addTeacher(Teacher teacher) {
        return teacherMapper.addTeacher(teacher);
    }

    @Override
    public int deleteTeacher(int id) {
        return teacherMapper.deleteTeacher(id);
    }

    @Override
    public List<Teacher> getTeachersMult() {
        return   teacherMapper.getTeachers();
    }


}
