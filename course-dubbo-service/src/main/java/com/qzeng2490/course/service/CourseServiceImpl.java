package com.qzeng2490.course.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.qzeng2490.course.dto.CourseDTO;
import com.qzeng2490.course.mapper.CourseMapper;
import com.qzeng2490.thrift.user.UserInfo;
import com.qzeng2490.thrift.user.dto.TeacherDTO;
import org.apache.thrift.TException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by liming
 */
@Service(interfaceClass = ICourseService.class)
@Component
public class CourseServiceImpl implements ICourseService {


    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private ServiceProvider serviceProvider;



    private TeacherDTO trans2Teacher(UserInfo userInfo) {
        TeacherDTO teacherDTO = new TeacherDTO();
        BeanUtils.copyProperties(userInfo, teacherDTO);
        return teacherDTO;
    }

    public List<CourseDTO> courseList() {
        List<CourseDTO> courseDTOS = courseMapper.listCourse();
        if(courseDTOS!=null) {
            for(CourseDTO courseDTO : courseDTOS) {
                Integer teacherId = courseMapper.getCourseTeacher(courseDTO.getId());
                if(teacherId!=null) {
                    try {
                        UserInfo userInfo = serviceProvider.getUserService().getTeacherById(teacherId);
                        courseDTO.setTeacherDTO(trans2Teacher(userInfo));
                    } catch (TException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
            }
        }
        return courseDTOS;
    }

}
