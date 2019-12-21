package com.xian.lebo.service;

import com.github.pagehelper.PageInfo;
import com.xian.lebo.pojo.Classes;

public interface ClassesService {

    PageInfo<Classes> getClasses(int indexPage, int pageSize);

    PageInfo<Classes> getClassesCnameLike(int indexPage, int pageSize,String cname);

    PageInfo<Classes> getClassesTnameLike(int indexPage, int pageSize,String tname);

    int addClasses(Classes classes);

    int deleteClasses(int id);

    Classes getClassesById(int id);

    int updateClassesById(Classes classes);

}
