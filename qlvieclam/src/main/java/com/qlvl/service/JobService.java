/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.qlvl.service;

import com.qlvl.pojo.Job;
import java.util.List;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;


/**
 *
 * @author ACER
 */
public interface JobService {
    List<Job> getJob(Map<String,String> params);
    Long countJob();
    boolean addJob(Job j);
    Job getJobById(int id);
    boolean deleteJob(int id);
    Job addJobJwt(Map<String, String> params, MultipartFile avatar);
    List<Job> getJobByEmpl(int id);
    Job updateJobJwt(Map<String, String> params, MultipartFile avatar);
}
