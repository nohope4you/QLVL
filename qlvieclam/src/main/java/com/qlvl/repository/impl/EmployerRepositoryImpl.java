/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.repository.impl;
import com.qlvl.pojo.Employer;
import com.qlvl.repository.EmployerRepository;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import org.hibernate.HibernateException;
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
public class EmployerRepositoryImpl implements EmployerRepository{
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Employer> getEmp(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        Query query = session.createQuery("FROM Employer where isApproved=0");
        return query.getResultList();
    }

    @Override
    public boolean checkEmployer(Employer e) {
        Session s = this.factory.getObject().getCurrentSession();
        if(e.getId()!=null){
            Boolean x = true;
            e.setIsApproved(x);
            s.update(e);
            return true;
        }
            return false;
    }
    @Override
    public Employer getEmployerByID(int id) {
       Session s = this.factory.getObject().getCurrentSession();
       return s.get(Employer.class,id);
    }

    @Override
    public boolean addEmployer(Employer e) {
         Session s = this.factory.getObject().getCurrentSession();
          try {
            if (e.getId() == null) {
                s.save(e);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
