/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.service.impl;
import com.qlvl.pojo.City;
import com.qlvl.repository.CityRepository;
import com.qlvl.service.CityService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class CityServiceImpl implements CityService{

    @Autowired
    public CityRepository CityRepo;
    
    @Override
    public List<City> getCity() {
      return this.CityRepo.getCity();
    }

    @Override
    public City getCityById(int id) {
       return this.CityRepo.getCityById(id);  
    }
    
}
