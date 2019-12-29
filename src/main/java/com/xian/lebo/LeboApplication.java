package com.xian.lebo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class LeboApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeboApplication.class, args);
        //再一次测试开发分支
    }

}
