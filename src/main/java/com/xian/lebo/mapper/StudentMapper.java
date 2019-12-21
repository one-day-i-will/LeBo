package com.xian.lebo.mapper;

import com.xian.lebo.pojo.Student;
import com.xian.lebo.pojo.StudentTest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("select * from student")
    List<Student> getStudents();

    @Select("select * from student where sname like '%${sname}%'")
    List<Student> getStudentsLike(String sname);

    @Select("select * from student where id =#{id}")
    Student getStudentById(int id);

    @Update("UPDATE student\n" +
            "SET `sname` =#{sname},\n" +
            "  `school` = #{school},\n" +
            "  `sphone` = #{sphone},\n" +
            "  `startDate` = #{startDate},\n" +
            "  `renewDate` = #{renewDate},\n" +
            "  `project` = #{project},\n" +
            "  `cid` = #{cid},\n" +
            "  `duration` = #{duration}\n" +
            "WHERE `id` = #{id}")
    int updateStudent(Student student);

    @Update("update student set `duration` =`duration`- #{duration}")
    int updateDuration(int useTime);

    @Insert("INSERT INTO `student`\n" +
            "            (\n" +
            "             `sname`,\n" +
            "             `school`,\n" +
            "             `sphone`,\n" +
            "             `startDate`,\n" +
            "             `renewDate`,\n" +
            "             `project`,\n" +
            "             `cid`,\n" +
            "             `duration`)\n" +
            "VALUES (\n" +
            "        #{sname},\n" +
            "        #{school},\n" +
            "        #{sphone},\n" +
            "        #{startDate},\n" +
            "        #{renewDate},\n" +
            "        #{project},\n" +
            "        #{cid},\n" +
            "        #{duration})")
     int addStudent(Student student);


    @Delete("delete from student where id= #{id}")
    int deleteStudent(int id);

    @Select("select id,sname as name,sphone from student where sname like '%${name}%' LIMIT 0, 5")
    List<StudentTest> getData(String name);

    @Update({
            "<script>",
            "update",
            "student",
            "set duration=duration-#{useTime}",
            "where id in",
            "<foreach collection='sid' item='id' open='(' separator=',' close=')'>",
            "#{id}",
            "</foreach>",
            "</script>"
    })
    int updateStudentMult(@Param("useTime") int useTime,@Param("sid") int[] sid);

    @Select("SELECT id,sname as name FROM student WHERE cid =#{cid}")
    List<StudentTest> getStudentByCid(int cid);
}
