/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.qlvl.repository;

import com.qlvl.pojo.Employer;
import com.qlvl.pojo.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ACER
 */
public interface EmployerRepository {
    List<Employer> getEmp(Map<String, String> params);
     boolean checkEmployer(Employer e);
     Employer getEmployerByID(int id);
     boolean addOrUpdateEmployer(Employer e);
     Employer getEmployerByUserId(int id);
     Employer FindEmployerByUserID(int id);
     List<Employer> getAllEmpl(Map<String,String> params);
     boolean addEmpJwt(Employer e);
}
