package com.peterjxl.learnspringbootwebadmin.service;

import com.peterjxl.learnspringbootwebadmin.bean.City;
import com.peterjxl.learnspringbootwebadmin.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    CityMapper cityMapper;


    public City getCityById(Long id) {
        return cityMapper.getById(id);
    }

    public void saveCity(City city) {
        cityMapper.insert(city);
    }
}
