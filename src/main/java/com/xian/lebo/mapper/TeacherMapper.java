package com.xian.lebo.mapper;


import com.xian.lebo.pojo.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TeacherMapper {

    @Select("select * from teacher")
    List<Teacher> getTeachers();

    @Select("select * from teacher where tname like '%${tname}%'")
    List<Teacher> getTeachersLike(String tname);

    @Select("select * from teacher where id =#{id}")
    Teacher getTeacher(int id);

    @Update("update teacher set tname=#{tname},tphone=#{tphone},worktime=#{worktime},teducation=#{teducation} where id =#{id}")
    int updateTeacherById(Teacher teacher);

    @Insert("INSERT INTO `teacher`\n" +
            "            (\n" +
            "             `tname`,\n" +
            "             `tphone`,\n" +
            "             `teducation`,\n" +
            "             `worktime`)\n" +
            "VALUES (\n" +
            "        #{tname},\n" +
            "        #{tphone},\n" +
            "        #{teducation},\n" +
            "        #{worktime})")
    int addTeacher(Teacher teacher);

    @Delete("delete from teacher where id =#{id}")
    int deleteTeacher(int id);
}
