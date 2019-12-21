package com.xian.lebo.mapper;

import com.xian.lebo.pojo.TimeTable;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TimeTableMapper {

    @Insert("insert into timetable (sid,tid,`classTime`,cid,useTime,`timeslot`) values(#{sid},#{tid},#{classTime},#{cid},#{useTime},#{timeslot})")
    int addTimeTable(TimeTable timeTable);

    @Select("SELECT tt.`timeslot`,tt.`id`,s.`sname`,tt.`classTime`,t.`tname`,tt.`useTime` FROM timetable tt LEFT JOIN student s ON tt.`sid`=s.`id` \n" +
            "\t\t\tLEFT JOIN teacher t ON tt.`tid`=t.`id` \n" +
            "\t\t\tLEFT JOIN project p ON tt.`cid`=p.`id` order by tt.`classTime` desc")
    List<TimeTable> getTimeTables();

    //根据学生姓名查
    @Select("SELECT tt.`timeslot`,tt.`id`,s.`sname`,tt.`classTime`,t.`tname`,tt.`useTime` FROM timetable tt LEFT JOIN student s ON tt.`sid`=s.`id` \n" +
            "\t\t\tLEFT JOIN teacher t ON tt.`tid`=t.`id` \n" +
            "\t\t\tLEFT JOIN project p ON tt.`cid`=p.`id` where s.sname like '%${sname}%' order by tt.`classTime` desc")
    List<TimeTable> getTimeTablesByStu(String sname);

    //根据老师姓名查
    @Select("SELECT tt.`timeslot`,tt.`id`,s.`sname`,tt.`classTime`,t.`tname`,tt.`useTime` FROM timetable tt LEFT JOIN student s ON tt.`sid`=s.`id` \n" +
            "\t\t\tLEFT JOIN teacher t ON tt.`tid`=t.`id` \n" +
            "\t\t\tLEFT JOIN project p ON tt.`cid`=p.`id` where t.tname like '%${tname}%' order by tt.`classTime` desc")
    List<TimeTable> getTimeTablesByTea(String tname);

    //根据老师学生查
    @Select("SELECT tt.`timeslot`,tt.`id`,s.`sname`,tt.`classTime`,t.`tname`,tt.`useTime` FROM timetable tt LEFT JOIN student s ON tt.`sid`=s.`id` \n" +
            "\t\t\tLEFT JOIN teacher t ON tt.`tid`=t.`id` \n" +
            "\t\t\tLEFT JOIN project p ON tt.`cid`=p.`id` where t.tname like '%${tname}%' and s.sname like '%${sname}%' order by tt.`classTime` desc")
    List<TimeTable> getTimeTablesStuTea(String tname,String sname);

    @Delete("delete from timetable where id=#{id}")
    int deleteTimeTable(int id);

    //根据时间段排序
    @Select("SELECT tt.`timeslot`,tt.`id`,s.`sname`,tt.`classTime`,t.`tname`,tt.`useTime` FROM timetable tt LEFT JOIN student s ON tt.`sid`=s.`id`\n" +
            "            LEFT JOIN teacher t ON tt.`tid`=t.`id`\n" +
            "            LEFT JOIN project p ON tt.`cid`=p.`id` WHERE tt.`classTime` BETWEEN #{beginTime} AND #{endTime} AND s.`sname` LIKE '%${sname}%'\n" +
            "            ORDER BY tt.`classTime` DESC")
    List<TimeTable> getTimeTablesByTimeStu(String beginTime,String endTime,String sname);

    @Select("SELECT tt.`timeslot`,tt.`id`,s.`sname`,tt.`classTime`,t.`tname`,tt.`useTime` FROM timetable tt LEFT JOIN student s ON tt.`sid`=s.`id`\n" +
            "            LEFT JOIN teacher t ON tt.`tid`=t.`id`\n" +
            "            LEFT JOIN project p ON tt.`cid`=p.`id` WHERE tt.`classTime` BETWEEN #{beginTime} AND #{endTime} AND t.`tname` LIKE '%${tname}%'\n" +
            "            ORDER BY tt.`classTime` DESC")
    List<TimeTable> getTimeTablesByTimeTea(String beginTime,String endTime,String tname);


    @Select("SELECT tt.`timeslot`,tt.`id`,s.`sname`,tt.`classTime`,t.`tname`,tt.`useTime` FROM timetable tt LEFT JOIN student s ON tt.`sid`=s.`id`\n" +
            "            LEFT JOIN teacher t ON tt.`tid`=t.`id`\n" +
            "            LEFT JOIN project p ON tt.`cid`=p.`id` WHERE tt.`classTime` BETWEEN #{beginTime} AND #{endTime} \n" +
            "            ORDER BY tt.`classTime` DESC")
    List<TimeTable> getTimeTableByTime(String beginTime,String endTime);


    @Insert({
            "<script>",
            "insert into timetable(sid,tid,`classTime`,cid,useTime,`timeslot`) values ",
            "<foreach collection='sid' item='id'  index='index' separator=',' >",
            "(#{id},#{timeTable.tid},#{timeTable.classTime},#{timeTable.cid},#{timeTable.useTime},#{timeTable.timeslot})",
            "</foreach>",
            "</script>"
    })
    int addTimeTableMult(@Param("sid")int[] sid,TimeTable timeTable);
}
