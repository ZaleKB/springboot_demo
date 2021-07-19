package com.zale.admin.service;

import com.zale.admin.bean.City;


public interface CityService {

     City getById(Long id);

     void saveCity(City city);

}
