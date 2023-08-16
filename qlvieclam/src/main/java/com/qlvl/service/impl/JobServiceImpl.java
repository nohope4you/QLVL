/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.service.impl;
import com.qlvl.pojo.Job;
import com.qlvl.repository.JobRepository;
import com.qlvl.service.JobService;
import java.util.List;
import java.util.Map;
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
      
     return this.JobRepo.addJob(j);
    }
    
}