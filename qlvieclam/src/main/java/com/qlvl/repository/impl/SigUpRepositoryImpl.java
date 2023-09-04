/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.repository.impl;

import com.qlvl.pojo.User;
import com.qlvl.repository.SignUpRepository;
import java.util.List;
import javax.persistence.NonUniqueResultException;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
@PropertySource("classpath:configs.properties")
public class SigUpRepositoryImpl implements SignUpRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Autowired
    private BCryptPasswordEncoder passEncoder;

    @Override
    public boolean addUser(User u) {
        Session s = this.factory.getObject().getCurrentSession();
//       if(u.getPassword()!= u.getConfirmPwd())
//           return false;
        if (u.getId() == null) {
             u.setPassword(this.passEncoder.encode(u.getPassword()));
            if (u.getRoleID().getId() == 1) {
                u.setUserRole("ROLE_USER");
                s.save(u);
            } else {
                u.setUserRole("ROLE_EMP");
                s.save(u);
            }
        } else {

            if (u.getRoleID().getId() == 1) {
                u.setUserRole("ROLE_USER");
                s.update(u);
            } else {
                u.setUserRole("ROLE_EMP");
                s.update(u);
            }
        }
        return true;
    }

    @Override
    public User findUserByUsername(String username) {
       Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM User WHERE username=:un");
        q.setParameter("un", username);
        List results = q.getResultList();
        if (results.isEmpty()) return null;
        else if (results.size() == 1) return (User) results.get(0);
        throw new NonUniqueResultException();
    }

  
}
