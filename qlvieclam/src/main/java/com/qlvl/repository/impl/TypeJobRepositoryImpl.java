/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.repository.impl;
import com.qlvl.pojo.Typejob;
import com.qlvl.repository.TypeJobRepository;
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
public class TypeJobRepositoryImpl implements TypeJobRepository{
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Typejob> getTypeJob() {
        Session session = this.factory.getObject().getCurrentSession();
        Query query = session.createQuery("FROM Typejob");
        return query.getResultList();
    }

    @Override
    public Typejob getTypejobById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Typejob.class, id);    }
}
