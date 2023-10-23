/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.repository.impl;

import com.qlvl.pojo.Employer;
import com.qlvl.pojo.Employerreview;
import com.qlvl.pojo.User;
import com.qlvl.repository.ReviewRepository;
import com.qlvl.repository.UserRepository;
import java.util.List;
import java.util.Map;
import org.hibernate.HibernateError;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class ReviewRepositoryImpl implements ReviewRepository {

    @Autowired
    private UserRepository UserRepo;
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Employerreview> getReviewByEmployer(Employer e) {
        Session session = this.factory.getObject().getCurrentSession();
        Query query = session.createQuery("FROM Employerreview WHERE employerID.id=:eid");
        query.setParameter("eid", e.getId());
        return query.getResultList();
    }

    @Override
    public boolean addReview(Employerreview er) {
         Session s = this.factory.getObject().getCurrentSession();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User u = this.UserRepo.getUserByUserName(authentication.getName());
       
        try {
             if (er.getId() == null) {
                  er.setUserID(u);
                s.save(er);
                return true;
            } else {
                return false;
            }
        } catch (HibernateError ex) {
            ex.printStackTrace();
            return false;
        }

    }

   @Override
    public Employerreview addComment(Employerreview c) {
                Session s = this.factory.getObject().getCurrentSession();
        try {
            s.save(c);
            return c;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
