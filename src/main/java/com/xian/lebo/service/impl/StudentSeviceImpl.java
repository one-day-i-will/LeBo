package com.xian.lebo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xian.lebo.mapper.StudentMapper;
import com.xian.lebo.pojo.Student;
import com.xian.lebo.pojo.StudentTest;
import com.xian.lebo.pojo.TimeTable;
import com.xian.lebo.service.StudentService;
import com.xian.lebo.service.TimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentSeviceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;


    @Autowired
    TimeTableService timeTableService;

    @Override
    public  PageInfo<Student> getStudents(int pageIndex,int pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        List<Student> list = studentMapper.getStudents();
        PageInfo<Student> info=new PageInfo<Student>(list);
        return info;
    }

    @Override
    public  PageInfo<Student> getStudentsLike(int pageIndex,int pageSize,String sname) {
        PageHelper.startPage(pageIndex,pageSize);
        List<Student> list= studentMapper.getStudentsLike(sname);
        PageInfo<Student> info=new PageInfo<Student>(list);
        return info;

    }

    @Override
    public Student getStudentById(int id) {
        return studentMapper.getStudentById(id);
    }

    @Override
    public int updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    @Override
    public int updateDuration(int useTime) {
        return studentMapper.updateDuration(useTime);
    }

    @Override
    public int addStudent(Student student) {
        return studentMapper.addStudent(student);
    }

    @Override
    public int deleteStudent(int id) {
        return studentMapper.deleteStudent(id);
    }

    @Override
    public List<StudentTest> getData(String name) {
        return studentMapper.getData(name);
    }

    @Override
    public int updateStudentMult(int useTime, int[] sid) {
        return studentMapper.updateStudentMult(useTime,sid);
    }


    @Transactional
    @Override
    public void studentMult(int[] sid, TimeTable timeTable) {
        updateStudentMult(timeTable.getUseTime(),sid);
        timeTableService.addTimeTableMult(sid,timeTable);
    }

}
