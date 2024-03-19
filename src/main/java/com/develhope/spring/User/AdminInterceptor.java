package com.develhope.spring.User;

import com.develhope.spring.User.Entities.Admin;
import com.develhope.spring.User.Repositories.AdminRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
@Component
public class AdminInterceptor implements HandlerInterceptor {
    @Autowired
    private AdminRepository adminRepository;
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        for(Admin admin : adminRepository.findAll()){
            if(request.getRequestURL().toString().contains("/motorworld"+admin.getId()+"/admin")){
            return true;
            }
        }
        return false;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
