/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.controllers;

import com.qlvl.pojo.Job;
import com.qlvl.service.JobService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/api")
public class ApiJobController {

    @Autowired
    private JobService JobSer;

    @DeleteMapping("/createJob/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void DeleteJob(@PathVariable(value = "id") int id) {
        this.JobSer.deleteJob(id);
    }

    @RequestMapping("/GetJob/")
    @CrossOrigin
    public ResponseEntity<List<Job>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.JobSer.getJob(params), HttpStatus.OK);
    }
    @RequestMapping(path = "")

    @PostMapping(path = "/Job", consumes = {
        MediaType.MULTIPART_FORM_DATA_VALUE,
        MediaType.APPLICATION_JSON_VALUE
    })
    @ResponseStatus(HttpStatus.CREATED)
    public void addJob() {

    }

}
