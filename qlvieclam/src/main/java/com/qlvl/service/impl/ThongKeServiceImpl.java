/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.service.impl;

import com.qlvl.repository.ThongKeRepository;
import com.qlvl.service.ThongKeService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class ThongKeServiceImpl implements ThongKeService{

    @Autowired
    private ThongKeRepository ThongKeRepo;
    
    @Override
    public List<Integer> getNumberMajor(Map<String, String> params) {
     return this.ThongKeRepo.getNumberMajor(params);
    }

    @Override
    public List<String> getNameMajor(Map<String, String> params) {
       return this.ThongKeRepo.getNameMajor(params);
    }

    @Override
    public List<Integer> getNumberByYear(int year) {
       return this.ThongKeRepo.getNumberByYear(year);
    }

    @Override
    public List<String> getNameByYear(int year) {
      return this.ThongKeRepo.getNameByYear(year);
    }

    @Override
    public List<Integer> GetNumberQuy1(int year) {
     return this.ThongKeRepo.GetNumberQuy1(year);
    }

    @Override
    public List<String> GetNameQuy1(int year) {
     return this.ThongKeRepo.GetNameQuy1(year);
    }

    @Override
    public List<Integer> GetNumberQuy2(int year) {
      return this.ThongKeRepo.GetNumberQuy2(year);
    }

    @Override
    public List<String> GetNameQuy2(int year) {
     return this.ThongKeRepo.GetNameQuy2(year);
    }

    @Override
    public List<Integer> GetNumberQuy3(int year) {
     return this.ThongKeRepo.GetNumberQuy3(year);
    }

    @Override
    public List<String> GetNameQuy3(int year) {
       return this.ThongKeRepo.GetNameQuy3(year);
    }

    @Override
    public List<Integer> GetNumberQuy4(int year) {
      return this.ThongKeRepo.GetNumberQuy4(year);
    }

    @Override
    public List<String> GetNameQuy4(int year) {
     return this.ThongKeRepo.GetNameQuy4(year);
    }
    
}
