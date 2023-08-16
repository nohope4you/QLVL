/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.qlvl.service;

import com.qlvl.pojo.City;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ACER
 */
public interface CityService {
    List<City> getCity(Map<String,String> params);
}
