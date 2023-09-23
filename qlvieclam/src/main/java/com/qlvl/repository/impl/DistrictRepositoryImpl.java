/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.repository.impl;
import com.qlvl.pojo.District;
import com.qlvl.repository.DistrictRepository;
import java.util.ArrayList;
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
public class DistrictRepositoryImpl implements DistrictRepository{
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<District> getDistrict() {
        Session session = this.factory.getObject().getCurrentSession();
        Query query = session.createQuery("FROM District");
        return query.getResultList();
    }

    @Override
    public District getDistrictById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(District.class, id);
    }
}
