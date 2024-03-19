//package com.develhope.spring.User;
//
//import com.develhope.spring.User.Controllers.CustomerController;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Component
//public class SpringMVCConfiguration implements WebMvcConfigurer {
//    @Autowired
//    private  AdminInterceptor adminInterceptor;
//    @Autowired
//    private SalesmanInterceptor salesmanInterceptor;
//    @Autowired
//    private CustomerInterceptor customerInterceptor;
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(adminInterceptor);
//        registry.addInterceptor(salesmanInterceptor);
//        registry.addInterceptor(customerInterceptor);
//    }
//}
