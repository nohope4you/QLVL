/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.service.impl;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.qlvl.pojo.Job;
import com.qlvl.repository.JobRepository;
import com.qlvl.service.JobService;
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
public class JobServiceImpl implements JobService{

    @Autowired
    private JobRepository JobRepo;
    
    @Autowired
    private Cloudinary cloudinary;
     
    @Override
    public List<Job> getJob(Map<String, String> params) {
       return this.JobRepo.getJob(params);
    }

    @Override
    public Long countJob() {
     return this.JobRepo.countJob();
    }

    @Override
    public boolean addJob(Job j) {
      if(!j.getFile().isEmpty()){
          try {
             Map res= this.cloudinary.uploader().upload(j.getFile().getBytes(), ObjectUtils.asMap("resource_type","auto"));
              j.setAvatarJob(res.get("secure_url").toString());
          } catch (IOException ex) {
              Logger.getLogger(JobServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
     return this.JobRepo.addJob(j);
    }

    @Override
    public Job getJobById(int id) {
     return this.JobRepo.getJobById(id);
    }

    @Override
    public boolean deleteJob(int id) {
     return this.JobRepo.deleteJob(id);
    }
    
}