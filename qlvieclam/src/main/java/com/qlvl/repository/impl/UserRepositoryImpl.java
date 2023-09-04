/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.repository.impl;


import com.qlvl.pojo.Role;
import com.qlvl.pojo.User;
import com.qlvl.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.NonUniqueResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Autowired
    private BCryptPasswordEncoder passEncoder;

    @Override
    public User getUserByUserName(String username) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM User WHERE username=:un");
        q.setParameter("un", username);
        return (User) q.getSingleResult();
    }

    @Override
    public User findUserByUserName(String username) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM User WHERE username=:un");
        q.setParameter("un", username);
        List results = q.getResultList();
        if (results.isEmpty()) {
            return null;
        } else if (results.size() == 1) {
            return (User) results.get(0);
        }
        throw new NonUniqueResultException();
    }

    @Override
    public User getUserById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(User.class, id);
    }

    @Override
    public boolean addUser(User u) {
        Session s = this.factory.getObject().getCurrentSession();

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
    public List<User> getUsername(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User u = this.getUserByUserName(authentication.getName());
        String id = u.getUsername();

        Query query = session.createQuery("FROM User where username=:id");
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public List<User> getUsernameCriteria(Map<String, String> params) {
         Session session = this.factory.getObject().getCurrentSession();
          CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<User> q = b.createQuery(User.class);
         Root root = q.from(User.class);
        q.select(root);
        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String name = params.get("name");
            if (name != null && !name.isEmpty()) {
                predicates.add(b.like(root.get("ten"), String.format("%%%s%%", name)));
               
            }
             String major = params.get("major");
            if (major != null && !major.isEmpty()) {
                predicates.add(b.like(root.get("nganhNghe"), String.format("%%%s%%", major)));  
            }
            predicates.add(b.like(root.get("userRole"),"ROLE_USER"));
            

           
              q.where(predicates.toArray(Predicate[]::new));
        }
        Query query = session.createQuery(q);
          return query.getResultList();
    }

    @Override
    public boolean authUser(String username, String password) {
        User  u = this.getUserByUserName(username);
        
        return this.passEncoder.matches(password, u.getPassword());
    }    

}
