package com.zale.admin.service.impl;

import com.zale.admin.bean.City;
import com.zale.admin.mapper.CityMapper;
import com.zale.admin.service.CityService;
//import io.micrometer.core.instrument.Counter;
//import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityMapper cityMapper;




    public City getById(Long id){
        return cityMapper.getById(id);
    }

    public void saveCity(City city) {
        cityMapper.insert(city);

    }
}
