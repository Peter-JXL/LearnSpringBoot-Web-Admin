package com.peterjxl.learnspringbootwebadmin.service;

import com.peterjxl.learnspringbootwebadmin.bean.Student;
import com.peterjxl.learnspringbootwebadmin.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public Student selectStudentById(Integer id) {
        return studentMapper.selectStudentById(id);
    }
}
