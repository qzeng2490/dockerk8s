package com.qzeng2490.course;

import com.qzeng2490.course.filter.CourseFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liming
 */
@SpringBootApplication
public class ServiceApplication {

    public static void main(String args[]) {
        SpringApplication.run(ServiceApplication.class, args);
    }

//    @Bean
//    public FilterRegistrationBean filterRegistrationBean(CourseFilter courseFilter ) {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(courseFilter);
//
//        List<String> urlPatterns = new ArrayList<String>();
//        urlPatterns.add("/*");
//        filterRegistrationBean.setUrlPatterns(urlPatterns);
//        return filterRegistrationBean;
//    }
}
