/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.qlvl.repository;

import com.qlvl.pojo.Employer;
import com.qlvl.pojo.Employerreview;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface ReviewRepository {
    List<Employerreview> getReviewByEmployer(Employer e);
    boolean addReview(Employerreview er);
    Employerreview addComment(Employerreview c);
}
