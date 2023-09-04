/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.controllers;

import com.qlvl.pojo.Employer;
import com.qlvl.service.EmployerService;
import com.qlvl.service.MajorService;
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
public class CheckEmployerController {

    @Autowired
    private EmployerService EmpSer;
       @Autowired
    private MajorService MajorService;
  

    @GetMapping("/CheckEmployer")
    public String CheckEmp(Model model) {
        model.addAttribute("MAJOR", this.MajorService.getMajor());
        model.addAttribute("EMPLOYER", new Employer());
        return "CheckEmployer";
    }

    @GetMapping("/CheckEmployer/{id}")
    public String UpdateView(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("EMPLOYER", this.EmpSer.getEmployerByID(id));
        return "CheckEmployer";
    }

    @PostMapping("/CheckEmployer")
    public String add(@ModelAttribute(value = "EMPLOYER") @Valid Employer e, BindingResult rs) {
      if (!rs.hasErrors()) {
            if (EmpSer.addOrUpdateEmployer(e) == true) {
            
                return "redirect:/Admin";
            }
        }
        return "redirect:/CheckEmployer";
    }
}
