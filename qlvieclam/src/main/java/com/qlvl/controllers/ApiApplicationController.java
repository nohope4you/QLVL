/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.controllers;

import com.cloudinary.http44.api.Response;
import com.qlvl.pojo.Application;
import com.qlvl.service.ApplicationService;
import com.qlvl.service.ThongKeService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/api")
public class ApiApplicationController {
        @Autowired
    private ApplicationService AppRepo;

    @Autowired
    private ThongKeService ThongKeSer;

    @RequestMapping("/GetThongKeByNumberMajor/")
    @CrossOrigin
    public ResponseEntity<List<Application>> getApplication(@RequestParam Map<String, String> params) {
        List applyJob = this.ThongKeSer.getNumberMajor(params);
        return ResponseEntity.ok(applyJob);
    }

    @RequestMapping("/GetThongKeByNameMajor/")
    @CrossOrigin
    public ResponseEntity<List<Application>> getNameMajor(@RequestParam Map<String, String> params) {
        List applyJob = this.ThongKeSer.getNameMajor(params);
        return ResponseEntity.ok(applyJob);
    }

    @RequestMapping("/GetNameByYear/{id}")
    @CrossOrigin
    public ResponseEntity<List<Application>> getNameByYear(@RequestParam Map<String, String> params,
            @PathVariable(value = "id") int year) {
        List applyJob = this.ThongKeSer.getNameByYear(year);
        return ResponseEntity.ok(applyJob);
    }

    @RequestMapping("/GetNumber/{id}")
    @CrossOrigin
    public ResponseEntity<List<Application>> getNumberByYear(@RequestParam Map<String, String> params,
            @PathVariable(value = "id") int year) {
        List applyJob = this.ThongKeSer.getNumberByYear(year);
        return ResponseEntity.ok(applyJob);
    }

    @RequestMapping("/GetNameQuy1/{id}")
    @CrossOrigin
    public ResponseEntity<List<Application>> GetNameQuy1(@RequestParam Map<String, String> params,
            @PathVariable(value = "id") int year) {
        List applyJob = this.ThongKeSer.GetNameQuy1(year);
        return ResponseEntity.ok(applyJob);
    }

    @RequestMapping("/GetNumberQuy1/{id}")
    @CrossOrigin
    public ResponseEntity<List<Application>> GetNumberQuy1(@RequestParam Map<String, String> params,
            @PathVariable(value = "id") int year) {
        List applyJob = this.ThongKeSer.GetNumberQuy1(year);
        return ResponseEntity.ok(applyJob);
    }
 @RequestMapping("/GetNameQuy2/{id}")
    @CrossOrigin
    public ResponseEntity<List<Application>> GetNameQuy2(@RequestParam Map<String, String> params,
            @PathVariable(value = "id") int year) {
        List applyJob = this.ThongKeSer.GetNameQuy2(year);
        return ResponseEntity.ok(applyJob);
    }

    @RequestMapping("/GetNumberQuy2/{id}")
    @CrossOrigin
    public ResponseEntity<List<Application>> GetNumberQuy2(@RequestParam Map<String, String> params,
            @PathVariable(value = "id") int year) {
        List applyJob = this.ThongKeSer.GetNumberQuy2(year);
        return ResponseEntity.ok(applyJob);
    }
    
    
    @RequestMapping("/GetNameQuy3/{id}")
    @CrossOrigin
    public ResponseEntity<List<Application>> GetNameQuy3(@RequestParam Map<String, String> params,
            @PathVariable(value = "id") int year) {
        List applyJob = this.ThongKeSer.GetNameQuy3(year);
        return ResponseEntity.ok(applyJob);
    }

    @RequestMapping("/GetNumberQuy3/{id}")
    @CrossOrigin
    public ResponseEntity<List<Application>> GetNumberQuy3(@RequestParam Map<String, String> params,
            @PathVariable(value = "id") int year) {
        List applyJob = this.ThongKeSer.GetNumberQuy3(year);
        return ResponseEntity.ok(applyJob);
    }
    
    @RequestMapping("/GetNameQuy4/{id}")
    @CrossOrigin
    public ResponseEntity<List<Application>> GetNameQuy4(@RequestParam Map<String, String> params,
            @PathVariable(value = "id") int year) {
        List applyJob = this.ThongKeSer.GetNameQuy4(year);
        return ResponseEntity.ok(applyJob);
    }

    @RequestMapping("/GetNumberQuy4/{id}")
    @CrossOrigin
    public ResponseEntity<List<Application>> GetNumberQuy4(@RequestParam Map<String, String> params,
            @PathVariable(value = "id") int year) {
        List applyJob = this.ThongKeSer.GetNumberQuy4(year);
        return ResponseEntity.ok(applyJob);
    }
    
}
