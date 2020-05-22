package com.swjd.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        //不需要登入可以直接访问
        if(uri.indexOf("login")>0||uri.indexOf("Login")>0){
            return true;
        }
        if(uri.indexOf("main")>0||uri.indexOf("Main")>0){
            return true;
        }

        //转发到登入界面
        request.getRequestDispatcher("/toLogin").forward(request,response);
        return false;
    }
}
