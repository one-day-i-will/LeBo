package com.xian.lebo.service;

import com.github.pagehelper.PageInfo;
import com.xian.lebo.pojo.TimeTable;

public interface TimeTableService {
    void addTimeTable(TimeTable timeTable);
    PageInfo<TimeTable> getTimeTables(int pageIndex, int pageSize);
    PageInfo<TimeTable> getTimeTablesByStu(int pageIndex, int pageSize,String sname);
    PageInfo<TimeTable> getTimeTablesByTea(int pageIndex, int pageSize,String tname);
    PageInfo<TimeTable> getTimeTablesStuTea(int pageIndex, int pageSize,String tname,String sname);
    PageInfo<TimeTable> getTimeTablesByTimeStu(int pageIndex, int pageSize,String beginTime, String endTime, String sname);
    PageInfo<TimeTable> getTimeTablesByTimeTea(int pageIndex, int pageSize,String beginTime, String endTime, String tname);
    PageInfo<TimeTable> getTimeTableByTime(int pageIndex, int pageSize,String beginTime, String endTime);
    int deleteTimeTable(int id);
    //批量增加
    int addTimeTableMult(int[] sid, TimeTable timeTable);
}
