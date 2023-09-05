/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.qlvl.service;

import com.qlvl.pojo.Application;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
public interface ApplicationService {
    Application getAppById(int id);
    boolean addApp(Application app);
     Application addAppJwt(Map<String, String> params, MultipartFile avatar);
}
