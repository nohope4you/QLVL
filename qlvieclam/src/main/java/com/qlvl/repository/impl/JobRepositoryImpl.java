/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.repository.impl;
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
public class JobRepositoryImpl implements JobRepository{
    @Autowired
    private LocalSessionFactoryBean factory;

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
        if (j.getEmployerID() == null) {
            int em = 1;
            Employer e = new Employer(em);
            j.setEmployerID(e);
            
            s.save(j);
        }
        return true;
    }
}
