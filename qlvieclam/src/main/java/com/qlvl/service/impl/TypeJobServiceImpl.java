/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.service.impl;
import com.qlvl.pojo.Typejob;
import com.qlvl.repository.TypeJobRepository;
import com.qlvl.service.TypeJobService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class TypeJobServiceImpl implements TypeJobService {

    @Autowired
    public TypeJobRepository TypeJobRepo;

    @Override
    public List<Typejob> getTypeJob() {
        return this.TypeJobRepo.getTypeJob();
    }

    @Override
    public Typejob getTypejobById(int id) {
        return this.TypeJobRepo.getTypejobById(id);
    }

}