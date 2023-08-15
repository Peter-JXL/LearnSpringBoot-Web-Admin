package com.peterjxl.learnspringbootwebadmin.service;

import com.peterjxl.learnspringbootwebadmin.bean.Student;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {

     Student selectStudentById(Integer id);
}
