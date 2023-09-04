/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.repository.impl;
import com.qlvl.pojo.City;
import com.qlvl.repository.CityRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
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
public class CityRepositoryImpl implements CityRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public List<City> getCity() {
        Session session = this.factory.getObject().getCurrentSession();
        Query query = session.createQuery("FROM City");
        return query.getResultList();
    }
}
