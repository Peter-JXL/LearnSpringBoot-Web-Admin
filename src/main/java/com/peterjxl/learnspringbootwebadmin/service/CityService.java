package com.peterjxl.learnspringbootwebadmin.service;

import com.peterjxl.learnspringbootwebadmin.bean.City;
import org.springframework.stereotype.Service;

@Service
public interface CityService {

    City getCityById(Long id);

    void saveCity(City city);
}
