/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.repository.impl;

import com.qlvl.pojo.Application;
import com.qlvl.repository.ThongKeRepository;
import java.util.List;
import java.util.Map;
import javassist.convert.Transformer;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class ThongKeRepositoryImpl implements ThongKeRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Integer> getNumberMajor(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        Query query = session.createQuery("SELECT COUNT(*) FROM  Application GROUP BY ngheNghiep");

        return query.getResultList();
    }

    @Override
    public List<Integer> getNumberByYear(int year) {
        Session session = this.factory.getObject().getCurrentSession();
        Query query = session.createQuery("SELECT COUNT(*) FROM  Application WHERE YEAR(createDate)=:cd GROUP BY ngheNghiep");
        query.setParameter("cd", year);
        return query.getResultList();
    }

    @Override
    public List<String> getNameMajor(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        Query query = session.createQuery("SELECT ngheNghiep FROM  Application GROUP BY ngheNghiep");

        return query.getResultList();
    }

    @Override
    public List<String> getNameByYear(int year) {
        Session session = this.factory.getObject().getCurrentSession();
        Query query = session.createQuery("SELECT ngheNghiep FROM  Application WHERE YEAR(createDate)=:cd GROUP BY ngheNghiep");
        query.setParameter("cd", year);
        return query.getResultList();
    }

    
    
    
    
    
    @Override
    public List<Integer> GetNumberQuy1(int year) {
    Session session = this.factory.getObject().getCurrentSession();
        Query query = session.createQuery("SELECT COUNT(*) FROM  Application WHERE YEAR(createDate)=:cd AND (MONTH(createDate)=1 or MONTH(createDate)=2 or MONTH(createDate)=3) GROUP BY ngheNghiep");
        query.setParameter("cd", year);
        return query.getResultList();
    }

    @Override
    public List<String> GetNameQuy1(int year) {
    Session session = this.factory.getObject().getCurrentSession();
        Query query = session.createQuery("SELECT ngheNghiep FROM  Application WHERE YEAR(createDate)=:cd AND (MONTH(createDate)=1 or MONTH(createDate)=2 or MONTH(createDate)=3) GROUP BY ngheNghiep");
        query.setParameter("cd", year);
        return query.getResultList();   
    }

    @Override
    public List<Integer> GetNumberQuy2(int year) {
       Session session = this.factory.getObject().getCurrentSession();
        Query query = session.createQuery("SELECT COUNT(*) FROM  Application WHERE YEAR(createDate)=:cd AND (MONTH(createDate)=4 or MONTH(createDate)=5 or MONTH(createDate)=6) GROUP BY ngheNghiep");
        query.setParameter("cd", year);
        return query.getResultList();
    }

    @Override
    public List<String> GetNameQuy2(int year) {
    Session session = this.factory.getObject().getCurrentSession();
        Query query = session.createQuery("SELECT ngheNghiep FROM  Application WHERE YEAR(createDate)=:cd AND(MONTH(createDate)=4 or MONTH(createDate)=5 or MONTH(createDate)=6)  GROUP BY ngheNghiep");
        query.setParameter("cd", year);
        return query.getResultList();  
    }

    @Override
    public List<Integer> GetNumberQuy3(int year) {
     Session session = this.factory.getObject().getCurrentSession();
        Query query = session.createQuery("SELECT COUNT(*) FROM  Application WHERE YEAR(createDate)=:cd AND (MONTH(createDate)=7 or MONTH(createDate)=8 or MONTH(createDate)=9) GROUP BY ngheNghiep");
        query.setParameter("cd", year);
        return query.getResultList();
    }

    @Override
    public List<String> GetNameQuy3(int year) {
    Session session = this.factory.getObject().getCurrentSession();
        Query query = session.createQuery("SELECT ngheNghiep FROM  Application WHERE YEAR(createDate)=:cd AND (MONTH(createDate)=7 or MONTH(createDate)=8 or MONTH(createDate)=9)  GROUP BY ngheNghiep");
        query.setParameter("cd", year);
        return query.getResultList();  
    }

    @Override
    public List<Integer> GetNumberQuy4(int year) {
       Session session = this.factory.getObject().getCurrentSession();
        Query query = session.createQuery("SELECT COUNT(*) FROM  Application WHERE YEAR(createDate)=:cd AND MONTH(createDate) BETWEEN 10 AND 12 GROUP BY ngheNghiep");
        query.setParameter("cd", year);
        return query.getResultList();
    }

    @Override
    public List<String> GetNameQuy4(int year) {
    Session session = this.factory.getObject().getCurrentSession();
        Query query = session.createQuery("SELECT ngheNghiep FROM  Application WHERE YEAR(createDate)=:cd  AND MONTH(createDate) BETWEEN 10 AND 12 GROUP BY ngheNghiep");
        query.setParameter("cd", year);
        return query.getResultList(); 
    }

   
}
