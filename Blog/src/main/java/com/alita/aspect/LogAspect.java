package com.alita.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


/**
 * @Author: Alita 1650810671@qq.com
 * @Description:
 * @Date: Created in 15:44 2020/2/14
 * @Modified By:
 */
@Aspect
@Component
public class LogAspect {
     private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Pointcut("execution(* com.alita.web.*.*(..))")
    public void log()
    {}

    @Before("log()")
    public void doBefore(JoinPoint joinPoint)
    {
        logger.info("--------doBefore----------");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest req = attributes.getRequest();
        String url = req.getRequestURL().toString();
        String ip = req.getRemoteAddr();
        String className = joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        RequestLog reqLog = new RequestLog(url,ip,className,args);
        logger.info("RequestLog {}",reqLog);

    }
    @After("log()")
    public void doAfter()
    {
        logger.info("-------------doAfter-----------");
    }

    @AfterReturning(returning = "result",pointcut = "log()")
    public void doAfterReturn(  Object result)
    {
        logger.info("Result: {}"+result);
    }

    private  class RequestLog{
        private String url;
        private String ip;
        private String className;
        private Object[] args;

        public RequestLog(String url,String ip,String className, Object[] args){
            this.url=url;
            this.ip=ip;
            this.className= className;
            this.args =args;

        }

        @Override
        public String toString() {
            return "RequestLog{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", className='" + className + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }


    }
}
