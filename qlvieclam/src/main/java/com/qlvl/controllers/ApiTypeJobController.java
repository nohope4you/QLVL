/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.controllers;

import com.qlvl.pojo.Typejob;
import com.qlvl.service.TypeJobService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/api")
public class ApiTypeJobController {
    @Autowired
    private TypeJobService TypeService;
    @GetMapping("/GetTypeJob/")
    @CrossOrigin
    public ResponseEntity<List<Typejob>> list() {
        return new ResponseEntity<>(this.TypeService.getTypeJob(), HttpStatus.OK);
    }
}
