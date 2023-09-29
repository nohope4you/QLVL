/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.service.impl;

import com.qlvl.pojo.Employer;
import com.qlvl.pojo.Employerreview;
import com.qlvl.pojo.User;
import com.qlvl.repository.ReviewRepository;
import com.qlvl.repository.UserRepository;
import com.qlvl.service.ReviewService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    private ReviewRepository ReviewRepo;
    
        @Autowired
    private UserRepository userRepo;
    
    @Override
    public List<Employerreview> getReviewByEmployer(Employer e) {
        return this.ReviewRepo.getReviewByEmployer(e);
    }

    @Override
    public boolean addReview(Employerreview er) {
     return this.ReviewRepo.addReview(er);
    }
    
    @Override
    public Employerreview addComment(Employerreview c) {
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User u = this.userRepo.getUserByUserName(authentication.getName());
        c.setUserID(u);
        
        return this.ReviewRepo.addComment(c);
    }
}
