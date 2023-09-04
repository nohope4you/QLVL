/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.controllers;

import com.qlvl.pojo.Employer;
import com.qlvl.pojo.Employerreview;
import com.qlvl.service.EmployerService;
import com.qlvl.service.ReviewService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Admin
 */
@Controller
public class ReviewDetailController {

    @Autowired
    private EmployerService EmpSer;
    
    @Autowired
    private ReviewService ReviewSer;

    @GetMapping("/ReviewDetail")
    @Transactional
    public String ReviewDetail(Model model) {
        return "ReviewDetail";
    }

    @GetMapping("/ReviewDetail/{id}")
    @Transactional
    public String UpdateView(Model model, @PathVariable(value = "id") int id,Employer e) {
        model.addAttribute("ALLREVIEW", this.ReviewSer.getReviewByEmployer(e));
        model.addAttribute("EMPLOYER",this.EmpSer.getEmployerByID(id));
        model.addAttribute("REVIEW", new Employerreview());
        return "ReviewDetail";
    }
    @PostMapping("/ReviewDetail")
    public String addReview(@ModelAttribute(value = "REVIEW") @Valid Employerreview er, BindingResult rs) {
       if (!rs.hasErrors()) {
            if (ReviewSer.addReview(er) == true) {
              
                return "redirect:/";
            }
        }
        return "redirect:/ReviewDetail";
    }
   
}
