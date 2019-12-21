package com.xian.lebo.controller;

import com.github.pagehelper.PageInfo;
import com.xian.lebo.pojo.TimeTable;
import com.xian.lebo.service.TimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/timeTable")
public class TimeTableController {

    @Autowired
    TimeTableService tableService;

    @PostMapping("/add")
    @ResponseBody
    public String addTimeTable(TimeTable timeTable){
        String flag="0";
        try {
            tableService.addTimeTable(timeTable);
            flag="1";
        }
        catch (Exception e){
        }
       return flag;
    }

    @GetMapping("/list")
    public String listTimeTable(@RequestParam(name="indexPage",defaultValue = "1") int indexPage,
                                @RequestParam(name = "pageSize" ,defaultValue = "5") int pageSize,
                                @RequestParam(name = "sname",defaultValue = "") String sname,
                                @RequestParam(name = "tname",defaultValue = "") String tname,
                                @RequestParam(name = "beginTime",defaultValue = "") String beginTime,
                                @RequestParam(name = "endTime",defaultValue = "") String endTime,
                                Model model){

        //同时满足
        PageInfo<TimeTable> info =null;
        if((sname!=null&&!sname.equals(""))&&(tname!=null&&!tname.equals(""))&&(beginTime==null||beginTime.equals(""))&&(endTime==null||endTime.equals(""))){
            info=tableService.getTimeTablesStuTea(indexPage,pageSize,tname,sname);
        }
        //根据老师姓名查
        else if((tname!=null&&!tname.equals(""))&&(sname==null||sname.equals(""))&&(beginTime==null||beginTime.equals(""))&&(endTime==null||endTime.equals("")))
        {
            info=tableService.getTimeTablesByTea(indexPage,pageSize,tname);
        }
        //根据学生姓名查
        else if((sname!=null&&!sname.equals(""))&&(tname==null||tname.equals(""))&&(beginTime==null||beginTime.equals(""))&&(endTime==null||endTime.equals(""))){
            info=tableService.getTimeTablesByStu(indexPage,pageSize,sname);
        }
        //根据时间和同学姓名查
        else if((sname!=null&&!sname.equals(""))&&(beginTime!=null&&!beginTime.equals(""))&&(endTime!=null&&!endTime.equals(""))){
            info=tableService.getTimeTablesByTimeStu(indexPage,pageSize,beginTime,endTime,sname);
        }
        //根据时间和老师名字查
        else if((tname!=null&&!tname.equals(""))&&(beginTime!=null&&!beginTime.equals(""))&&(endTime!=null&&!endTime.equals(""))){
            info=tableService.getTimeTablesByTimeTea(indexPage,pageSize,beginTime,endTime,tname);
        }
        //根据时间
        else if((sname==null||sname.equals(""))&&(tname==null||tname.equals(""))&&(beginTime!=null&&!beginTime.equals(""))&&(endTime!=null&&!endTime.equals(""))){
            info=tableService.getTimeTableByTime(indexPage,pageSize,beginTime,endTime);
        }
        else {
            info=tableService.getTimeTables(indexPage,pageSize);
        }
        model.addAttribute("info",info);
        model.addAttribute("sname",sname);
        model.addAttribute("tname",tname);
        model.addAttribute("beginTime",beginTime);
        model.addAttribute("endTime",endTime);
        return "timeTable";
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deleteTimeTable(@PathVariable("id") int id)
    {
        String flag="0";
        try {
            tableService.deleteTimeTable(id);
            flag="1";
        }
        catch (Exception e){

        }
        return flag;
    }

}
