/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.repository.impl;

import com.qlvl.pojo.Application;
import com.qlvl.pojo.User;
import com.qlvl.repository.ApplicationRepository;
import com.qlvl.repository.UserRepository;
import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
@PropertySource("classpath:configs.properties")
public class ApplicationRepositoryImpl implements ApplicationRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Autowired
    private UserRepository UserRepo;

    @Override
    public boolean addApp(Application app) {
        Session s = this.factory.getObject().getCurrentSession();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User u = this.UserRepo.getUserByUserName(authentication.getName());
        app.setUserID(u);
        Date date = new Date();
        app.setCreateDate(date);
//        if(app.getHo().isEmpty() || app.getTen().isEmpty()||app.getEmail().isEmpty()||
//                app.getSdt().isEmpty()||app.getNamKinhNghiem()==null|| app.getFile().isEmpty())
//            return false;
        try {
            if (app.getId() == null) {

                s.save(app);
                return true;
            } else {
                return false;
            }

        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }

    }

    @Override
    public Application getAppById(int id) {
       Session s = this.factory.getObject().getCurrentSession();
       return s.get(Application.class, id);
    }

    @Override
    public boolean addAppJwt(Application A) {
        Session s = this.factory.getObject().getCurrentSession();
        Date date = new Date();
        A.setCreateDate(date);
//        if(app.getHo().isEmpty() || app.getTen().isEmpty()||app.getEmail().isEmpty()||
//                app.getSdt().isEmpty()||app.getNamKinhNghiem()==null|| app.getFile().isEmpty())
//            return false;
        try {
            if (A.getId() == null) {

                s.save(A);
                return true;
            } else {
                return false;
            }

        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
