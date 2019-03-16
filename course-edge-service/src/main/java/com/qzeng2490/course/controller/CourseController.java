package com.qzeng2490.course.controller;

import com.alibaba.dubbo.config.annotation.Reference;

import com.qzeng2490.course.dto.CourseDTO;
import com.qzeng2490.course.service.ICourseService;
import com.qzeng2490.thrift.user.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by liming
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    @Reference
    private ICourseService courseService;

    @RequestMapping(value = "/courseList", method = RequestMethod.GET)
    @ResponseBody
    public List<CourseDTO> courseList(HttpServletRequest request) {

        UserDTO user = (UserDTO)request.getAttribute("user");
        System.out.println(user.toString());

        return courseService.courseList();
    }
}
