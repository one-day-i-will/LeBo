package com.xian.lebo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xian.lebo.mapper.ClassesMapper;
import com.xian.lebo.pojo.Classes;
import com.xian.lebo.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassesServiceImpl implements ClassesService {

    @Autowired
    ClassesMapper classesMapper;

    @Override
    public PageInfo<Classes> getClasses(int indexPage, int pageSize) {
        PageHelper.startPage(indexPage,pageSize);
        List<Classes> list = classesMapper.getClasses();
        PageInfo<Classes> info=new PageInfo<Classes>(list);
        return info;
    }

    @Override
    public PageInfo<Classes> getClassesCnameLike(int indexPage, int pageSize, String cname) {
        PageHelper.startPage(indexPage,pageSize);
        List<Classes> list = classesMapper.getClassesCnameLike(cname);
        PageInfo<Classes> info=new PageInfo<Classes>(list);
        return info;
    }

    @Override
    public PageInfo<Classes> getClassesTnameLike(int indexPage, int pageSize, String tname) {
        PageHelper.startPage(indexPage,pageSize);
        List<Classes> list = classesMapper.getClassesTnameLike(tname);
        PageInfo<Classes> info=new PageInfo<Classes>(list);
        return info;
    }

    @Override
    public int addClasses(Classes classes) {
        return classesMapper.addClasses(classes);
    }

    @Override
    public int deleteClasses(int id) {
        return classesMapper.deleteClasses(id);
    }

    @Override
    public Classes getClassesById(int id) {
        return classesMapper.getClassesById(id);
    }

    @Override
    public int updateClassesById(Classes classes) {
        return classesMapper.updateClassesById(classes);
    }
}
