/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.qlvl.pojo.Application;
import com.qlvl.pojo.Job;
import com.qlvl.pojo.User;
import com.qlvl.repository.ApplicationRepository;
import com.qlvl.service.ApplicationService;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private ApplicationRepository AppRepo;

    @Override
    public boolean addApp(Application app) {
        if (!app.getFile().isEmpty()) {
            try {
                Map ress= this.cloudinary.uploader().upload(app.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type","auto"));
                app.setFileCV(ress.get("secure_url").toString());
                
            } catch (IOException ex) {
                Logger.getLogger(ApplicationServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this.AppRepo.addApp(app);
    }

    @Override
    public Application getAppById(int id) {
     return this.AppRepo.getAppById(id);
    }

}
