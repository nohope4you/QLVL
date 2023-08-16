/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.service.impl;
import com.qlvl.pojo.Employer;
import com.qlvl.repository.EmployerRepository;
import com.qlvl.service.EmployerService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class EmployerServiceImpl implements EmployerService{

    @Autowired
    private EmployerRepository EmployRepo;
    @Override
    public List<Employer> getEmp(Map<String, String> params) {
        return this.EmployRepo.getEmp(params);
    }

    @Override
    public boolean checkEmployer(Employer e) {
      return this.EmployRepo.checkEmployer(e);
    }

    @Override
    public Employer getEmployerByID(int id) {
       return this.EmployRepo.getEmployerByID(id);
    }

    @Override
    public boolean addEmployer(Employer e) {
     return this.EmployRepo.addEmployer(e);
    }
    
}
