package com.peterjxl.learnspringbootwebadmin.service.impl;

import com.peterjxl.learnspringbootwebadmin.bean.Student;
import com.peterjxl.learnspringbootwebadmin.mapper.StudentMapper;
import com.peterjxl.learnspringbootwebadmin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public Student selectStudentById(Integer id) {
        return studentMapper.selectStudentById(id);
    }
}
