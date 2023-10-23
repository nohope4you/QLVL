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
import com.qlvl.repository.JobRepository;
import com.qlvl.repository.UserRepository;
import com.qlvl.service.ApplicationService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
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
    private ApplicationRepository AppRepo;
    @Autowired
    private LocalSessionFactoryBean factory;
   @Autowired
    private JobRepository jobrepo;
    @Autowired
    private UserRepository userRepo;
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

        Application app = new Application();
        Job id = this.jobrepo.getJobById(Integer.parseInt(params.get("jobID")));
        User u = this.userRepo.getUserById(Integer.parseInt(params.get("userID")));
        app.setHo(params.get("ho"));
        app.setTen(params.get("ten"));
        app.setEmail(params.get("email"));
        app.setSdt(params.get("sdt"));
        app.setNgheNghiep(params.get("ngheNghiep"));
        app.setTrinhDoHocVan(params.get("trinhDoHocVan"));
        app.setAddressUser(params.get("addressUser"));
        app.setJobID(id);
        app.setUserID(u);
        app.setNamKinhNghiem(Integer.valueOf(params.get("namKinhNghiem")));
        app.setTuoi(Integer.valueOf(params.get("tuoi")));
        if (!avatar.isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(avatar.getBytes(), 
                        ObjectUtils.asMap("resource_type", "auto"));
                app.setFileCV(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(ApplicationServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.AppRepo.addAppJwt(app);
        return app;
    }

    @Override
    public boolean CheckUserAndJobApplication(Application app) {
    return this.AppRepo.CheckUserAndJobApplication(app);
    }

    @Override
    public List<Application> getApplicationByJobId(int id) {
     return this.AppRepo.getApplicationByJobId(id);
    }

    @Override
    public List<Application> getApplicationByUserId(int userid) {
      return this.AppRepo.getApplicationByUserId(userid);
    }

    @Override
    public boolean deleteApp(int id) {
     return this.AppRepo.deleteApp(id);
    }

    @Override
    public boolean deleteAppByJobID(int id) {
     return this.AppRepo.deleteAppByJobID(id);
    }

}
