package com.peterjxl.learnspringbootwebadmin.service.impl;

import com.peterjxl.learnspringbootwebadmin.bean.City;
import com.peterjxl.learnspringbootwebadmin.mapper.CityMapper;
import com.peterjxl.learnspringbootwebadmin.service.CityService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityMapper cityMapper;

    Counter counter;
    public CityServiceImpl(MeterRegistry meterRegistry){
        counter = meterRegistry.counter("cityService.saveCity.count");
    }

    public City getCityById(Long id) {
        return cityMapper.getById(id);
    }

    public void saveCity(City city) {
        counter.increment();
        cityMapper.insert(city);
    }
}
