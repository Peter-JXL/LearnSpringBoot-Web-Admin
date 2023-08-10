package com.peterjxl.learnspringbootwebadmin.mapper;

import com.peterjxl.learnspringbootwebadmin.bean.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {

    Student selectStudentById(Integer id);

}
