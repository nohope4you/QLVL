/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.qlvl.service;

import com.qlvl.pojo.Employer;
import com.qlvl.pojo.Employerreview;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ReviewService {

    List<Employerreview> getReviewByEmployer(Employer e);

    boolean addReview(Employerreview er);
    
    Employerreview addComment(Employerreview c);
}
