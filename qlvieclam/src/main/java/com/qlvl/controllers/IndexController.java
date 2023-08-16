/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.controllers;

import com.qlvl.service.CityService;
import com.qlvl.service.DistrictService;
import com.qlvl.service.EducationService;
import com.qlvl.service.JobService;
import com.qlvl.service.MajorService;
import com.qlvl.service.TypeJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ACER
 */
@Controller
public class IndexController {

    @Autowired
    private JobService jobService;
        @Autowired
    private DistrictService DistrictService;
    
    @Autowired
    private MajorService MajorService;
    @Autowired
    private CityService CityService;
    @Autowired
    private TypeJobService TypeService;
    
    @Autowired
    private EducationService EduService;
    
    
    @RequestMapping("/")
    @Transactional
    public String Index(Model model){

        model.addAttribute("JOB", this.jobService.getJob(null));
        model.addAttribute("CITY",this.CityService.getCity(null));

        model.addAttribute("DISTRICT",this.DistrictService.getDistrict(null));

        model.addAttribute("MAJOR",this.MajorService.getMajor(null));
        
        model.addAttribute("EDUCATION",this.EduService.getEdu(null));
        model.addAttribute("TYPEJOB",this.TypeService.getTypeJob(null));
        return "index";
    }
}
