/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.service.impl;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.qlvl.pojo.Job;
import com.qlvl.pojo.Employer;
import com.qlvl.repository.JobRepository;
import com.qlvl.service.ApplicationService;
import com.qlvl.service.CityService;
import com.qlvl.service.DistrictService;
import com.qlvl.service.EducationService;
import com.qlvl.service.EmployerService;
import com.qlvl.service.JobService;
import com.qlvl.service.MajorService;
import com.qlvl.service.TypeJobService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Converts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
@Service
public class JobServiceImpl implements JobService{
        @Autowired
    private ApplicationService AppRepo;
    @Autowired
    private JobService JobSer;
        @Autowired
    private DistrictService DistrictService;
        @Autowired
    private EmployerService emps;
    @Autowired
    private MajorService MajorService;
    @Autowired
    private CityService CityService;
    @Autowired
    private TypeJobService TypeService;

    @Autowired
    private EducationService EduService;
    
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
             Map res= this.cloudinary.uploader().upload(j.getFile().getBytes(), 
                     ObjectUtils.asMap("resource_type","auto"));
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

    @Override
    public Job addJobJwt(Map<String, String> params, MultipartFile avatar) {

    Job j = new Job();
    Employer e = this.emps.getEmployerByUserId(Integer.parseInt(params.get("idEmp")));
    
    j.setNameJob(params.get("nameJob"));
    j.setSalary(params.get("salary"));
    j.setSoLuongTuyenDung(Integer.valueOf(params.get("soLuongTuyenDung")));
    j.setKinhNghiem(Integer.valueOf(params.get("kinhNghiem")));
    j.setAge(Integer.valueOf(params.get("age")));
    j.setCityID(this.CityService.getCityById(Integer.parseInt(params.get("cityID"))));
    j.setMajorID(this.MajorService.getMajorById(Integer.parseInt(params.get("majorID"))));
    j.setEmployerID(e);
    j.setTypeJobID(this.TypeService.getTypejobById(Integer.parseInt(params.get("typeJobID"))));
    j.setEducationID(this.EduService.getEducationById(Integer.parseInt(params.get("educationID"))));
    j.setDistricID(this.DistrictService.getDistrictById(Integer.parseInt(params.get("districID"))));
            if (!avatar.isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(avatar.getBytes(), 
                        ObjectUtils.asMap("resource_type", "auto"));
                j.setAvatarJob(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(JobServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        this.JobRepo.addJobJwt(j);
        return j;
    }
    
}