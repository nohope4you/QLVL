/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.controllers;

import com.qlvl.pojo.Employer;
import com.qlvl.pojo.User;
import com.qlvl.repository.UserRepository;
import com.qlvl.service.EmployerService;
import com.qlvl.service.JobService;
import com.qlvl.service.MajorService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Admin
 */
@Controller
public class EmployerController {

    @Autowired
    private EmployerService EmplSer;
    @Autowired
    private UserRepository UserRepo;
    @Autowired
    private MajorService MajorService;
    @Autowired
    private JobService jobService;

    @GetMapping("/Employer")
    @Transactional
    public String Employer(Model model) {

        if (this.jobService.getJobByEmpl(0) != null) {
            model.addAttribute("MAJOR", this.MajorService.getMajor());
            model.addAttribute("emp", new Employer());
            model.addAttribute("jobEmploy", this.jobService.getJobByEmpl(0));
            return "Employer";
        } else {
            model.addAttribute("MAJOR", this.MajorService.getMajor());
            model.addAttribute("emp", new Employer());

            return "Employer";
        }

    }

    @PostMapping("/Employer")
    public String addEmployer(@ModelAttribute(value = "emp") @Valid Employer e, RedirectAttributes redirect, Model model, BindingResult rs) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User u = this.UserRepo.findUserByUserName(authentication.getName());
        if (EmplSer.FindEmployerByUserID(u.getId()) != null) {
            redirect.addFlashAttribute("message", "Tài khoản đã đăng ký nhà tuyển dụng rồi");

            return "redirect:/Employer";
        }
        if (!rs.hasErrors()) {
            if (EmplSer.addOrUpdateEmployer(e) == true) {
                return "redirect:/";
            }
        }

        return "redriect:/";

    }
}
