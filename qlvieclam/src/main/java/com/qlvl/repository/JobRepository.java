/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.qlvl.repository;

import com.qlvl.pojo.Job;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ACER
 */
public interface JobRepository {
    List<Job> getJob(Map<String,String> params);
    Long countJob();
    boolean addJob(Job j);
    Job getJobById(int id);
    boolean deleteJob(int userId);
    List<Job> getJobByEmpl(int id);
    boolean addJobJwt(Job j);
}
