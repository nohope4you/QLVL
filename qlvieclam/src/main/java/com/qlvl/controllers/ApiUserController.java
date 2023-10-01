/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.controllers;

import com.qlvl.components.JwtService;
import com.qlvl.pojo.Employer;
import com.qlvl.pojo.Employerreview;
import com.qlvl.pojo.User;
import com.qlvl.service.EmployerService;
import com.qlvl.service.ReviewService;
import com.qlvl.service.UserService;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ACER
 */
@RestController
@RequestMapping("/api")
public class ApiUserController {
    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserService userService;
    @Autowired
    private EmployerService empService;
        @Autowired
    private ReviewService review;
    
    @PostMapping("/login/")
    @CrossOrigin
    public ResponseEntity<String> login(@RequestBody User user) {
        if (this.userService.authUser(user.getUsername(), user.getPassword()) == true) {
            String token = this.jwtService.generateTokenLogin(user.getUsername());
            
            return new ResponseEntity<>(token, HttpStatus.OK);
        }

        return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
    }
    
    @PostMapping(path = "/users/", 
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, 
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin
    public ResponseEntity<User> addUser(@RequestParam Map<String, String> params, @RequestPart MultipartFile avatar) {
        User user = this.userService.addUserJwt(params, avatar);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    
    @GetMapping(path = "/current-user/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<User> details(Principal user) {
        User u = this.userService.getUserByUn(user.getName());
        return new ResponseEntity<>(u, HttpStatus.OK);
    }
    
    
    @PostMapping(path = "/employer/", 
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, 
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin
    public ResponseEntity<Employer> addEmp(@RequestParam Map<String, String> params, @RequestPart MultipartFile avatar) {
        Employer emp = this.empService.addEmpJwt(params, avatar);
        return new ResponseEntity<>(emp, HttpStatus.CREATED);
    }
    
    @RequestMapping("/GetEmp/")
    @CrossOrigin
    public ResponseEntity<List<Employer>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.empService.getAllEmpl(params), HttpStatus.OK);
    }
    
    @RequestMapping("/GetEmp/{id}")
    @CrossOrigin
    public ResponseEntity<Employer> details(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(this.empService.getEmployerByID(id), HttpStatus.OK);
    }
    
        @GetMapping("/GetEmp/{EmpId}/comments/")
    @CrossOrigin
    public ResponseEntity<List<Employerreview>> listComments(@PathVariable(value = "EmpId") int id) {
        Employer e = this.empService.getEmployerByID(id);
        return new ResponseEntity<>(this.review.getReviewByEmployer(e), HttpStatus.OK);
    }
    
    @PostMapping(path="/comments/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Employerreview> addComment(@RequestBody Employerreview comment) {
        Employerreview c = this.review.addComment(comment);
        
        return new ResponseEntity<>(c, HttpStatus.CREATED);
    }
    
}
