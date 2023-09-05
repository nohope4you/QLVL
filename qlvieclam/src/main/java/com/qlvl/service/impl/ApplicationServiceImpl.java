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
import com.qlvl.repository.UserRepository;
import com.qlvl.service.ApplicationService;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private Cloudinary cloudinary;
        @Autowired
    private UserRepository userRepo;
    @Autowired
    private LocalSessionFactoryBean factory;
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
    
    @Override
    public Application addAppJwt(Map<String, String> params, MultipartFile avatar) {
        Session s = this.factory.getObject().getCurrentSession();
        Application app = new Application();
                int x= 1;
        Job id = new Job(x);
        User u = new User(x);
        
        app.setHo(params.get("ho"));
        app.setTen(params.get("ten"));
        app.setEmail(params.get("email"));
        app.setSdt(params.get("sdt"));
        app.setNgheNghiep(params.get("NgheNghiep"));
        app.setTrinhDoHocVan(params.get("trinhDoHocVan"));
        app.setAddressUser(params.get("addressUser"));
        app.setJobID(id);
        app.setUserID(u);
        app.setNamKinhNghiem(Integer.parseInt(params.get("NamKinhNghiem")));
        app.setTuoi(Integer.parseInt(params.get("Tuoi")));
        if (!avatar.isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(avatar.getBytes(), 
                        ObjectUtils.asMap("resource_type", "auto"));
                app.setFileCV(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.AppRepo.addApp(app);
        return app;
    }

}
