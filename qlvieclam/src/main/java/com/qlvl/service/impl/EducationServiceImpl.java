/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.service.impl;
import com.qlvl.pojo.Education;
import com.qlvl.repository.EducationRepository;
import com.qlvl.service.EducationService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class EducationServiceImpl implements EducationService {

    @Autowired
    public EducationRepository EduRepo;

    @Override
    public List<Education> getEdu() {
        return this.EduRepo.getEdu();
    }

}
