/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.controllers;

import com.qlvl.pojo.Application;
import com.qlvl.pojo.Employer;
import com.qlvl.pojo.Job;
import com.qlvl.service.ApplicationService;
import com.qlvl.service.EmployerService;
import com.qlvl.service.JobService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/api")
public class ApiJobController {

    @Autowired
    private JobService JobSer;
    @Autowired
    private ApplicationService AppRepo;

    @Autowired
    private EmployerService emps;

    @DeleteMapping("/createJob/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void DeleteJob(@PathVariable(value = "id") int id) {
        this.JobSer.deleteJob(id);
    }

    @DeleteMapping("/deleteJob/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CrossOrigin
    public void DeleteJobs(@PathVariable(value = "id") int id) {
        this.AppRepo.deleteAppByJobID(id);
        this.JobSer.deleteJob(id);
    }

    @RequestMapping("/GetJob/")
    @CrossOrigin
    public ResponseEntity<List<Job>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.JobSer.getJob(params), HttpStatus.OK);
    }

//    @GetMapping("/Emp/{id}")
//    @CrossOrigin
//    public ResponseEntity<Employer> emp(@PathVariable(value = "id") int id) {
//        return new ResponseEntity<>(this.emSer.FindEmployerByUserID(id), HttpStatus.OK);
//    }
    @GetMapping("/GetJob/{id}")
    @CrossOrigin
    public ResponseEntity<Job> details(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(this.JobSer.getJobById(id), HttpStatus.OK);
    }

//    @RequestMapping("/GetJobEmployer/{id}")
//    @CrossOrigin
//    public ResponseEntity<List<Job>> detailJobs(@PathVariable(value = "id") int id) {
//        return new ResponseEntity<>(this.JobSer.getJobByEmpl(null), HttpStatus.OK);
//    }
    @PostMapping(path = "/getApplication/")
    @CrossOrigin
    public ResponseEntity<Application> addAppJwt(@RequestParam Map<String, String> params, @RequestPart MultipartFile avatarapp) {
        Application app = this.AppRepo.addAppJwt(params, avatarapp);
        return new ResponseEntity<>(app, HttpStatus.CREATED);
    }

    @PostMapping(path = "/NewJob/",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin
    @ResponseStatus
    public ResponseEntity<Job> addJob(@RequestParam Map<String, String> params, @RequestPart MultipartFile avatarJob) {

        Job jb = this.JobSer.addJobJwt(params, avatarJob);
        return new ResponseEntity<>(jb, HttpStatus.CREATED);
    }

    @RequestMapping("/GetJobByEmp/")
    @CrossOrigin
    public ResponseEntity<List<Employer>> lists(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.emps.getEmp(params), HttpStatus.OK);
    }

    @PostMapping(path = "/UpdateJob/",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin
    @ResponseStatus
    public ResponseEntity<Job> UpdateJob(@RequestParam Map<String, String> params, @RequestPart MultipartFile avatarJob) {

        Job jsb = this.JobSer.updateJobJwt(params, avatarJob);
        return new ResponseEntity<>(jsb, HttpStatus.OK);
    }

}
