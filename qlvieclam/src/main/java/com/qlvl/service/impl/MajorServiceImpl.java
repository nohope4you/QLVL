/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.service.impl;
import com.qlvl.pojo.Major;
import com.qlvl.repository.MajorRepository;
import com.qlvl.service.MajorService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class MajorServiceImpl implements MajorService{

    @Autowired
    public MajorRepository MajorRepo;
    
    @Override
    public List<Major> getMajor() {
      return this.MajorRepo.getMajor();
    }
    
}