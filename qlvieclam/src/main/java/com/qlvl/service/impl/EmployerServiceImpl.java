/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.qlvl.pojo.Employer;
import com.qlvl.pojo.User;
import com.qlvl.repository.EmployerRepository;
import com.qlvl.service.EmployerService;
import java.io.IOException;
import java.util.List;
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
public class EmployerServiceImpl implements EmployerService {

    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private EmployerRepository EmployRepo;

    @Override
    public List<Employer> getEmp(Map<String, String> params) {
        return this.EmployRepo.getEmp(params);
    }

    @Override
    public boolean checkEmployer(Employer e) {
        return this.EmployRepo.checkEmployer(e);
    }

    @Override
    public Employer getEmployerByID(int id) {
        return this.EmployRepo.getEmployerByID(id);
    }

    @Override
    public boolean addOrUpdateEmployer(Employer e) {
        if(e.getId()!=null){
            e.setIsApproved(Boolean.TRUE);
        }
        else{
            e.setIsApproved(Boolean.FALSE);
        }
             
        if(!e.getFile().isEmpty()){
            try {
                Map res =this.cloudinary.uploader().upload(e.getFile().getBytes(), ObjectUtils.asMap("resource_type","auto"));
               e.setAvatar(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(EmployerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this.EmployRepo.addOrUpdateEmployer(e);
    }

    @Override
    public Employer getEmployerByUserId(int id) {
        
     return this.EmployRepo.getEmployerByUserId(id);
    }

    @Override
    public Employer FindEmployerByUserID(int id) {
    return this.EmployRepo.FindEmployerByUserID(id);
    }

    @Override
    public List<Employer> getAllEmpl(Map<String, String> params) {
     return this.EmployRepo.getAllEmpl(params);
    }

}
