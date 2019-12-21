package com.xian.lebo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xian.lebo.mapper.TimeTableMapper;
import com.xian.lebo.pojo.TimeTable;
import com.xian.lebo.service.StudentService;
import com.xian.lebo.service.TimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TimeTableServiceImpl implements TimeTableService {

    @Autowired
    TimeTableMapper timeTableMapper;

    @Autowired
    StudentService studentService;

    @Transactional
    @Override
    public void addTimeTable(TimeTable timeTable) {
        //增加记录到课程记录表
        timeTableMapper.addTimeTable(timeTable);
        //更新学生剩下的课时
        studentService.updateDuration(timeTable.getUseTime());
    }

    @Override
    public PageInfo<TimeTable> getTimeTables(int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        List<TimeTable> list = timeTableMapper.getTimeTables();
        PageInfo<TimeTable> info=new PageInfo<TimeTable>(list);
        return info;
    }

    @Override
    public PageInfo<TimeTable> getTimeTablesByStu(int pageIndex, int pageSize,String sname) {
        PageHelper.startPage(pageIndex,pageSize);
        List<TimeTable> list = timeTableMapper.getTimeTablesByStu(sname);
        PageInfo<TimeTable> info=new PageInfo<TimeTable>(list);
        return info;
    }

    @Override
    public PageInfo<TimeTable> getTimeTablesByTea(int pageIndex, int pageSize,String tname) {
        PageHelper.startPage(pageIndex,pageSize);
        List<TimeTable> list = timeTableMapper.getTimeTablesByTea(tname);
        PageInfo<TimeTable> info=new PageInfo<TimeTable>(list);
        return info;
    }

    @Override
    public PageInfo<TimeTable> getTimeTablesStuTea(int pageIndex, int pageSize, String tname, String sname) {
        PageHelper.startPage(pageIndex,pageSize);
        List<TimeTable> list = timeTableMapper.getTimeTablesStuTea(tname,sname);
        PageInfo<TimeTable> info=new PageInfo<TimeTable>(list);
        return info;
    }

    @Override
    public PageInfo<TimeTable> getTimeTablesByTimeStu(int pageIndex, int pageSize, String beginTime, String endTime, String sname) {
        PageHelper.startPage(pageIndex,pageSize);
        List<TimeTable> list = timeTableMapper.getTimeTablesByTimeStu(beginTime,endTime,sname);
        PageInfo<TimeTable> info=new PageInfo<TimeTable>(list);
        return info;
    }

    @Override
    public PageInfo<TimeTable> getTimeTablesByTimeTea(int pageIndex, int pageSize, String beginTime, String endTime, String tname) {
        PageHelper.startPage(pageIndex,pageSize);
        List<TimeTable> list = timeTableMapper.getTimeTablesByTimeTea(beginTime,endTime,tname);
        PageInfo<TimeTable> info=new PageInfo<TimeTable>(list);
        return info;
    }

    @Override
    public PageInfo<TimeTable> getTimeTableByTime(int pageIndex, int pageSize, String beginTime, String endTime) {
        PageHelper.startPage(pageIndex,pageSize);
        List<TimeTable> list = timeTableMapper.getTimeTableByTime(beginTime,endTime);
        PageInfo<TimeTable> info=new PageInfo<TimeTable>(list);
        return info;
    }

    @Override
    public int deleteTimeTable(int id) {
        return timeTableMapper.deleteTimeTable(id);
    }

    @Override
    public int addTimeTableMult(int[] sid, TimeTable timeTable) {
        return timeTableMapper.addTimeTableMult(sid,timeTable);
    }
}
