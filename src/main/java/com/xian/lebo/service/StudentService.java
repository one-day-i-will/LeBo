package com.xian.lebo.service;

import com.github.pagehelper.PageInfo;
import com.xian.lebo.pojo.Student;
import com.xian.lebo.pojo.StudentTest;
import com.xian.lebo.pojo.TimeTable;

import java.util.List;

public interface StudentService {
    PageInfo<Student> getStudents(int pageIndex,int pageSize);
    //根据名字查
    PageInfo<Student> getStudentsLike(int pageIndex, int pageSize, String sname);
    //根据学生Id查
    Student getStudentById(int id);
    //更新
    int updateStudent(Student student);
    //更新课时
    int updateDuration(int useTime);
    //添加学生
    int addStudent(Student student);
    //删除学生
    int deleteStudent(int id);

    //搜索学生
    List<StudentTest> getData(String name);

    //批量修改
    int updateStudentMult(int useTime,int[] sid);

    //学生批量操作
    void studentMult(int[] sid, TimeTable timeTable);


}
