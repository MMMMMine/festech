package com.festech.webapi.base.aop;

import com.alibaba.fastjson.JSONObject;
import com.festech.webapi.base.logger.BaseLogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @Package org.jon.lv.aop.WebLogAspect
 * @Description: WebLogAspect
 * Author lv bin
 * @date 2017/5/16 11:18
 * version V1.0.0
 */
@Aspect
@Component
@Order(-5)
public class WebLogAspect {

    /**
     * 定义一个切入点.
     * 解释下：
     * ~ 第一个 * 代表任意修饰符及任意返回值.
     * ~ 第二个 * 任意包名
     * ~ 第三个 * 代表任意方法.
     * ~ 第四个 * 定义在web包或者子包
     * ~ 第五个 * 任意方法
     * ~ .. 匹配任意数量的参数.
     */

    @Pointcut("execution(public * com.festech.webapi.controller.*.*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        // 接收到请求，记录请求内容
        BaseLogger.info("WebLogAspect.doBefore()");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        BaseLogger.info("URL : " + request.getRequestURL().toString());
        BaseLogger.info("HTTP_METHOD : " + request.getMethod());
        BaseLogger.info("IP : " + request.getRemoteAddr());
        BaseLogger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        if (joinPoint.getArgs().length == 0) {

            BaseLogger.info("ARGS : " + JSONObject.toJSONString(joinPoint.getArgs()));

        } else {

            BaseLogger.info("ARGS : " + JSONObject.toJSONString(joinPoint.getArgs()[0]));

        }
        //获取所有参数方法一：
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String paraName = enu.nextElement();
            BaseLogger.info(paraName + ": " + request.getParameter(paraName));
        }
        BaseLogger.info("WebLogAspect.doBefore() is success");

    }


    @AfterReturning("webLog()")
    public void doAfterReturning(JoinPoint joinPoint) {
        // 处理完请求，返回内容
        BaseLogger.info("WebLogAspect.doAfterReturning()");
    }

}
