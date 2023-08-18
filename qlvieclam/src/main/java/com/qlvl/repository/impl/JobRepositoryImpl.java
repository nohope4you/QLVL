/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.repository.impl;

import com.cloudinary.Cloudinary;
import com.qlvl.pojo.City;
import com.qlvl.pojo.Employer;
import com.qlvl.pojo.Job;
import com.qlvl.repository.JobRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ACER
 */
@Repository
@Transactional
@PropertySource("classpath:configs.properties")
public class JobRepositoryImpl implements JobRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Job> getJob(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Job> q = b.createQuery(Job.class);
        Root root = q.from(Job.class);
        q.select(root);
        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                predicates.add(b.like(root.get("namejob"), String.format("%%%s%%", kw)));
            }
            q.where(predicates.toArray(Predicate[]::new));
        }
        Query query = session.createQuery(q);
        if (params != null) {
            String page = params.get("page");
            if (page != null && !page.isEmpty()) {
                int p = Integer.parseInt(page);
                int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));

                query.setMaxResults(pageSize);
                query.setFirstResult((p - 1) * pageSize);
            }
        }
        return query.getResultList();
    }

    @Override
    public Long countJob() {
        Session session = this.factory.getObject().getCurrentSession();
        Query q = session.createQuery("SELECT Count(*) FROM Job");
        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public boolean addJob(Job j) {

        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (j.getEmployerID() == null) {
                int em = 1;
                Employer e = new Employer(em);

                j.setEmployerID(e);
                s.save(j);
            } else {
                s.update(j);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Job getJobById(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        return session.get(Job.class, id);
    }

    @Override
    public boolean deleteJob(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        Job j = this.getJobById(id);
        try{
            session.delete(j);
            return true;
        }
        catch(HibernateException ex){
            ex.printStackTrace();
            return false;
        }

    }
}
