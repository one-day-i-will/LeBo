package com.xian.lebo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class LeboApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeboApplication.class, args);
        //测试+1
        //master，develop合并结果
        //在github做了修改
    }

}
