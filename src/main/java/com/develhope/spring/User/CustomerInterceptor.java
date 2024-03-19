package com.develhope.spring.User;

import com.develhope.spring.User.Entities.Admin;
import com.develhope.spring.User.Entities.Customer;
import com.develhope.spring.User.Repositories.CustomerRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
@Component
public class CustomerInterceptor implements HandlerInterceptor {
    @Autowired
    private CustomerRepository customerRepository;
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        for(Customer customer : customerRepository.findAll()){
            if(request.getRequestURL().toString().contains("/motorworld"+customer.getId()+"/customer")){
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
