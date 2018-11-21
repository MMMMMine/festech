package com.festech.webapi.base.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class ApiRequestTimeRecordInterceptor implements HandlerInterceptor {

    public static String REQUEST_TIME = "http_request_time";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        request.setAttribute(REQUEST_TIME, new Date());
        return true;
    }

}
