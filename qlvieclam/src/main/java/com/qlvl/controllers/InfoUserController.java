/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.controllers;

import com.qlvl.pojo.User;
import com.qlvl.service.MajorService;
import com.qlvl.service.RoleService;
import com.qlvl.service.SignUpService;
import com.qlvl.service.UserService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
public class InfoUserController {

    @Autowired
    private UserService userService;
    @Autowired
    private MajorService MajorSer;
    @Autowired
    private RoleService RoleService;
    @Autowired
    private SignUpService SignUp;

    @GetMapping("/InfoUser")
    public String InfoUser(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("MAJOR", this.MajorSer.getMajor());
        model.addAttribute("roless", this.RoleService.getRole(null));
        model.addAttribute("USER", this.userService.getUsername(params));
        model.addAttribute("info", new User());

        return "InfoUser";
    }

    @GetMapping("/InfoUser/{id}")
    public String UpdateView(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("MAJOR", this.MajorSer.getMajor());
        model.addAttribute("roless", this.RoleService.getRole(null));
        model.addAttribute("info", this.userService.getUserById(id));
        return "InfoUser";
    }

    @PostMapping("/InfoUser")
    public String add(@ModelAttribute(value = "info") @Valid User u, BindingResult rs,Model model) {
        model.addAttribute("MAJOR", this.MajorSer.getMajor());
        model.addAttribute("roless", this.RoleService.getRole(null));
        if (SignUp.addUser(u) == true) {
            return "redirect:/";
        }

        return "redirect:/InfoUser";
    }

}
