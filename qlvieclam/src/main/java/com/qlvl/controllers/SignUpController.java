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
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Admin
 */
@Controller
public class SignUpController {

    @Autowired
    private SignUpService SignUp;
    @Autowired
    private MajorService MajorSer;
    @Autowired
    private RoleService RoleService;

    @GetMapping("/SignUp")
    public String SignUp(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("MAJOR", this.MajorSer.getMajor());
        model.addAttribute("roless", this.RoleService.getRole(null));
        model.addAttribute("signup", new User());
        return "SignUp";
    }

    @PostMapping("/SignUp")
    public String add(@ModelAttribute(value = "signup") User u, BindingResult rs, RedirectAttributes redirect) {
        if (SignUp.findUserByUsername(u.getUsername()) != null) {
            redirect.addFlashAttribute("message", "Tài khoản đã tồn tại");
            return "redirect:/SignUp";
        }
          if (SignUp.findUserByUsername(u.getUsername()) == null) {
            this.SignUp.addUser(u);
            return "login";
        }

        return "redirect:/SignUp";
    }
}
