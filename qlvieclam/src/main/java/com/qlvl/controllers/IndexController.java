/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.controllers;

import com.qlvl.pojo.User;
import com.qlvl.service.CityService;
import com.qlvl.service.DistrictService;
import com.qlvl.service.EducationService;
import com.qlvl.service.JobService;
import com.qlvl.service.MajorService;
import com.qlvl.service.TypeJobService;
import com.qlvl.service.UserService;
import java.util.Map;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ACER
 */
@Controller
@ControllerAdvice
@PropertySource("classpath:configs.properties")
public class IndexController {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private JobService jobService;
    @Autowired
    private DistrictService DistrictService;

    @Autowired
    private UserService userSer;
    @Autowired
    private MajorService MajorService;
    @Autowired
    private CityService CityService;
    @Autowired
    private TypeJobService TypeService;

    @Autowired
    private EducationService EduService;

    @Autowired
    private Environment env;

    @RequestMapping("/")
    public String Index(Model model, @RequestParam Map<String, String> params) {

        model.addAttribute("CITY", this.CityService.getCity());

        model.addAttribute("DISTRICT", this.DistrictService.getDistrict());

        model.addAttribute("MAJOR", this.MajorService.getMajor());

        model.addAttribute("EDUCATION", this.EduService.getEdu());

        model.addAttribute("jobs", this.jobService.getJob(null));

        model.addAttribute("TYPEJOB", this.TypeService.getTypeJob());
        model.addAttribute("JOB", this.jobService.getJob(params));

        
        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        long count = this.jobService.countJob();
        model.addAttribute("COUNT", Math.ceil(count * 1.0 / pageSize));
        return "index";
    }

}
