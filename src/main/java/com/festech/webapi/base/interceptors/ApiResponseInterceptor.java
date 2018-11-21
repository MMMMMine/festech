package com.festech.webapi.base.interceptors;

import com.alibaba.fastjson.JSONObject;
import com.festech.webapi.base.result.ResultDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@ControllerAdvice
public class ApiResponseInterceptor implements ResponseBodyAdvice {

    private Logger logger = LoggerFactory.getLogger(ApiResponseInterceptor.class);

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {

        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass,
                                  ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        // 响应结果执行
        if (mediaType != null && o != null
                && mediaType.includes(MediaType.APPLICATION_JSON)
                && o instanceof ResultDO) {

            if (serverHttpRequest instanceof ServletServerHttpRequest) {

                ServletServerHttpRequest request = (ServletServerHttpRequest) serverHttpRequest;

                HttpServletRequest httpServletRequest = request.getServletRequest();

                Date requestTime = (Date) httpServletRequest.getAttribute(ApiRequestTimeRecordInterceptor.REQUEST_TIME);

                long useTime = 0l;
                if (requestTime != null) {

                    useTime = System.currentTimeMillis() - requestTime.getTime();
                }

                Method method = methodParameter.getMethod();

                logger.info("request controller:" + method.getDeclaringClass() + " request method:" + method.getName());

                logger.info("request link:" + serverHttpRequest.getURI() + " times:" + useTime);

            }


            logger.info("response content:" + JSONObject.toJSONString(o));
        }

        return o;
    }
}
