package com.xian.lebo.controller;

import com.xian.lebo.mapper.StudentMapper;
import com.xian.lebo.mapper.TimeTableMapper;
import com.xian.lebo.mapper.UsersMapper;
import com.xian.lebo.pojo.Users;
import com.xian.lebo.service.ProjectService;
import com.xian.lebo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    UsersMapper usersMapper;

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    ProjectService projectService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    TimeTableMapper timeTableMapper;



//    @GetMapping("/xian")
//    public String toTestHtml(Model model){
//        List<Project> projectsMult = projectService.getProjectsMult();
//        List<Teacher> teachersMult = teacherService.getTeachersMult();
//        model.addAttribute("teachers",teachersMult);
//        model.addAttribute("projects",projectsMult);
//        return "studentUpdateMult";
//    }



    @GetMapping("/")
    public String toIndex(){
        return "redirect:/student/list";
    }

    @GetMapping("/login")
    public String toLogin(){
        return "login";
    }

    @PostMapping("/toLogin")
    public String login(Users users, Model model, HttpSession session) {
        Users user = usersMapper.getUser(users);
        if (user == null) {
            model.addAttribute("msg","账号或密码错误");
            return "/login";
        } else {
            session.setAttribute("user",user);
            return "redirect:/student/list";
        }
    }

    @GetMapping("/test")
    public String toTest(){
        return "pages-error-404";
    }


//    @GetMapping("/findByClass")
//    @ResponseBody
//    public List<StudentTest> testFindByClass(int clsId){
//        List<StudentTest> list=new ArrayList<StudentTest>();
//        if(clsId==1){
//            list.add(new StudentTest(1,"一班:xian11","1"));
//            list.add(new StudentTest(1,"一班:xian22","11"));
//            list.add(new StudentTest(1,"一班:xian33","111"));
//            list.add(new StudentTest(1,"一班:xian44","1111"));
//        }
//        else if(clsId==2){
//            list.add(new StudentTest(1,"二班:xian11","2"));
//            list.add(new StudentTest(1,"二班:xian22","22"));
//            list.add(new StudentTest(1,"二班:xian33","222"));
//            list.add(new StudentTest(1,"二班:xian44","2222"));
//        }
//        else if(clsId==3) {
//            list.add(new StudentTest(1,"三班:xian11","3"));
//            list.add(new StudentTest(1,"三班:xian22","33"));
//            list.add(new StudentTest(1,"三班:xian33","333"));
//            list.add(new StudentTest(1,"三班:xian44","3333"));
//        }
//        else {
//            list.add(new StudentTest(1,"0班:xian11","0"));
//            list.add(new StudentTest(1,"0班:xian22","00"));
//            list.add(new StudentTest(1,"0班:xian33","000"));
//            list.add(new StudentTest(1,"0班:xian44","0000"));
//        }
//        return list;
//    }
//
//
//    @RequestMapping("/tostudentUpdateMult2")
//    public String tostudentUpdateMult2(){
//        return "studentUpdateMult2";
//    }

}
