/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.controllers;

import com.qlvl.service.UserService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
public class SearchUserController {
    @Autowired
    private UserService UserSer;
    @GetMapping("/SearchUser")
    public String SearchUser(@RequestParam Map<String, String> params,Model model){
       model.addAttribute("USER",this.UserSer.getUsernameCriteria(params));
        return"SearchUser";
    }
}
