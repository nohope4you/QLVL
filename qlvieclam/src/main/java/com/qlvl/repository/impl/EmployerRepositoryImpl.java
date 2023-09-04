/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.repository.impl;

import com.qlvl.pojo.Employer;

import com.qlvl.pojo.User;
import com.qlvl.repository.EmployerRepository;
import com.qlvl.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.PluralAttribute;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ACER
 */
@Repository
@Transactional
@PropertySource("classpath:configs.properties")
public class EmployerRepositoryImpl implements EmployerRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;
    @Autowired
    private UserRepository UserRepo;

    @Override
    public List<Employer> getEmp(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();

        Query query = session.createQuery("FROM Employer where isApproved=FALSE");
        return query.getResultList();
    }

    @Override
    public boolean checkEmployer(Employer e) {
        Session s = this.factory.getObject().getCurrentSession();

        if (e.getId() != null) {
            Boolean x = true;

            e.setIsApproved(x);

            s.update(e);
            return true;
        }
        return false;
    }

    @Override
    public Employer getEmployerByUserId(int userId) {
        Session s = this.factory.getObject().getCurrentSession();
        Employer e = s.createQuery("FROM Employer WHERE userID.id=:userId", Employer.class)
                .setParameter("userId", userId)
                .uniqueResult();
        return e;

    }

    @Override
    public Employer getEmployerByID(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Employer.class, id);
    }

    @Override
    public boolean addOrUpdateEmployer(Employer e) {
        Session s = this.factory.getObject().getCurrentSession();

        try {
            if (e.getId() == null) {
                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                User u = this.UserRepo.getUserByUserName(authentication.getName());
                e.setUserID(u);
                s.save(e);
            } else {

                s.update(e);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Employer FindEmployerByUserID(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Employer WHERE userID.id=:userId", Employer.class);
        q.setParameter("userId", id);
        List results = q.getResultList();
        if (results.isEmpty()) {
            return null;
        } else if (results.size() == 1) {
            return (Employer) results.get(0);
        }
        throw new NonUniqueResultException();

    }

    @Override
    public List<Employer> getAllEmpl(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Employer> q = b.createQuery(Employer.class);
        Root root = q.from(Employer.class);
        q.select(root);
        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                predicates.add(b.like(root.get("nameEmployer"), String.format("%%%s%%", kw)));
            }
            q.where(predicates.toArray(Predicate[]::new));

        }
        Query query = session.createQuery(q);
        return query.getResultList();
    }
}
