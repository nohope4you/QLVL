/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.controllers;

import com.qlvl.service.EmployerService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author AdminController
 */
@Controller
public class AdminController {
    @Autowired
    private EmployerService EmpSer;
    
    @GetMapping("/Admin")
    @Transactional
    public String admin(Model model){
        model.addAttribute("EMP", this.EmpSer.getEmp(null));
        return"Admin";
    }
}
