/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.controllers;

import com.qlvl.pojo.Application;
import com.qlvl.pojo.Job;
import com.qlvl.service.ApplicationService;
import com.qlvl.service.CityService;
import com.qlvl.service.DistrictService;
import com.qlvl.service.EducationService;
import com.qlvl.service.JobService;
import com.qlvl.service.MajorService;
import com.qlvl.service.TypeJobService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
public class JobDetailController {

    @Autowired
    private JobService jobSer;
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

 

    @GetMapping("/JobDetail")
    @Transactional
    public String JobDetail(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("CITY", this.CityService.getCity());

        model.addAttribute("DISTRICT", this.DistrictService.getDistrict());

        model.addAttribute("MAJOR", this.MajorService.getMajor());

        model.addAttribute("EDUCATION", this.EduService.getEdu());
        model.addAttribute("TYPEJOB", this.TypeService.getTypeJob());
        model.addAttribute("JD", new Job());
        return "JobDetail";
    }

    @GetMapping("/JobDetail/{id}")
    public String UpdateView(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("CITY", this.CityService.getCity());
        
        model.addAttribute("DISTRICT", this.DistrictService.getDistrict());

        model.addAttribute("MAJOR", this.MajorService.getMajor());

        model.addAttribute("EDUCATION", this.EduService.getEdu());
        model.addAttribute("TYPEJOB", this.TypeService.getTypeJob());
        model.addAttribute("JD", this.jobSer.getJobById(id));
        return "JobDetail";
    }

  
}
