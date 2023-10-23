/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.repository.impl;
import com.qlvl.pojo.Major;
import com.qlvl.repository.MajorRepository;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author ACER
 */
@Repository
@Transactional
public class MajorRepositoryImpl implements MajorRepository{
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Major> getMajor() {
         Session session = this.factory.getObject().getCurrentSession();
        Query query = session.createQuery("FROM Major");
        return query.getResultList();
    }

     @Override
    public Major getMajorById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Major.class, id);    
    }
}
