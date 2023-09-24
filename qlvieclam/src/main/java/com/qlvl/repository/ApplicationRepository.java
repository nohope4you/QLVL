/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.qlvl.repository;

import com.qlvl.pojo.Application;



/**
 *
 * @author Admin
 */
public interface ApplicationRepository {
    Application getAppById(int id);
     boolean addApp(Application app);
     boolean addAppJwt (Application A);
}
