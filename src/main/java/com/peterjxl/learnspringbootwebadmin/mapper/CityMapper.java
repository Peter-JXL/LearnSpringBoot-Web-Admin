package com.peterjxl.learnspringbootwebadmin.mapper;

import com.peterjxl.learnspringbootwebadmin.bean.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CityMapper {

    @Select("select * from city where id = #{id}")
    City getById(Long id);

    void insert(City city);
}
