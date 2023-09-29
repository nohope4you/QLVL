/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.qlvl.service;

import com.qlvl.pojo.Employer;
import java.util.List;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ACER
 */
public interface EmployerService {

    List<Employer> getEmp(Map<String, String> params);

    boolean checkEmployer(Employer e);

    Employer getEmployerByID(int id);

    boolean addOrUpdateEmployer(Employer e);

    Employer getEmployerByUserId(int id);

    Employer FindEmployerByUserID(int id);
    List<Employer> getAllEmpl(Map<String, String> params);
    
        Employer addEmpJwt(Map<String, String> params, MultipartFile avatar);
}
