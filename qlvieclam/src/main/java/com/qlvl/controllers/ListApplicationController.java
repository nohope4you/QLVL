/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.controllers;

import com.qlvl.pojo.Application;
import com.qlvl.service.ApplicationService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
public class ListApplicationController {

    @Autowired
    private ApplicationService AppService;

    @GetMapping("/ListApplication")
    @Transactional
    public String ListApplication(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("Application", new Application());
        return "ListApplication";
    }
    

    @GetMapping("/ListApplication/{id}")
    @Transactional
    public String UpdateView(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("Applicationss", this.AppService.getApplicationByJobId(id));
        return "ListApplication";
    }
}
