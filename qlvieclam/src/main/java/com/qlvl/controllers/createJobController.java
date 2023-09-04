/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.controllers;

import com.qlvl.pojo.Job;
import com.qlvl.service.CityService;
import com.qlvl.service.DistrictService;
import com.qlvl.service.EducationService;
import com.qlvl.service.JobService;
import com.qlvl.service.MajorService;
import com.qlvl.service.TypeJobService;
import static java.lang.System.console;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Admin
 */
@Controller
public class createJobController {

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

   

    @GetMapping("/createJob")
    @Transactional
    public String createJob(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("CITY", this.CityService.getCity());

        model.addAttribute("DISTRICT", this.DistrictService.getDistrict());

        model.addAttribute("MAJOR", this.MajorService.getMajor());

        model.addAttribute("EDUCATION", this.EduService.getEdu());
        model.addAttribute("TYPEJOB", this.TypeService.getTypeJob());
        model.addAttribute("job", new Job());
        return "createJob";
    }

    @PostMapping("/createJob")
    public String add(@ModelAttribute(value = "job") @Valid Job j, BindingResult rs, RedirectAttributes redirect,Model model) {
          model.addAttribute("CITY", this.CityService.getCity());

        model.addAttribute("DISTRICT", this.DistrictService.getDistrict());

        model.addAttribute("MAJOR", this.MajorService.getMajor());

        model.addAttribute("EDUCATION", this.EduService.getEdu());
        model.addAttribute("TYPEJOB", this.TypeService.getTypeJob());
        if (!rs.hasErrors()) {
            if (jobSer.addJob(j) == true) {
              
                return "redirect:/";
            }
        }
        return "createJob";
    }

    @GetMapping("/createJob/{id}")
    public String UpdateView(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("CITY", this.CityService.getCity());

        model.addAttribute("DISTRICT", this.DistrictService.getDistrict());

        model.addAttribute("MAJOR", this.MajorService.getMajor());

        model.addAttribute("EDUCATION", this.EduService.getEdu());
        model.addAttribute("TYPEJOB", this.TypeService.getTypeJob());
        model.addAttribute("job", this.jobSer.getJobById(id));
        return "createJob";
    }
}
