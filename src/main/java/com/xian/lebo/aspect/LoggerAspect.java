package com.xian.lebo.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class LoggerAspect {

    private Logger logger=LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.xian.lebo.controller.*.*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String classMethod = joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName();
        String uri = request.getRequestURI();
        String ip = request.getRemoteAddr();
        Object[] args = joinPoint.getArgs();
        RequestLog result=new RequestLog(uri,ip,args,classMethod);
        logger.info("Result:{}",result);
    }

    //方法正确执行后
    @AfterReturning(pointcut = "pointCut()",returning = "result")
    public void doAfter(Object result)
    {
        logger.info("Result:{}",result);
    }

    //有异常后
    @AfterThrowing(pointcut = "pointCut()",throwing = "result")
    public void afterException(Exception result){
        logger.info("Result:{}",result);
    }

    private class RequestLog{
        private String uri;
        private String ip;
        private Object[] args;
        private String classMethod;

        public RequestLog(String uri, String ip, Object[] args, String classMethod) {
            this.uri = uri;
            this.ip = ip;
            this.args = args;
            this.classMethod = classMethod;
        }

        @Override
        public String toString() {
            return "RequestLog{" +
                    "uri='" + uri + '\'' +
                    ", ip='" + ip + '\'' +
                    ", args=" + Arrays.toString(args) +
                    ", classMethod='" + classMethod + '\'' +
                    '}';
        }
    }
}
