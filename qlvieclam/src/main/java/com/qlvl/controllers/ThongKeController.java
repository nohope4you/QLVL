/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.controllers;

import com.qlvl.service.ThongKeService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
public class ThongKeController {
    @Autowired
    private ThongKeService ThongKeSer;
    @GetMapping("/ThongKe")
    @Transactional
    public String ThongKe(Model model,Map<String, Integer> params){
        model.addAttribute("THONGKE",this.ThongKeSer.getNumberMajor(null));
        return "ThongKe";
    }
    
    
}
