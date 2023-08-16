/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.qlvl.service.impl;
import com.qlvl.pojo.Role;
import com.qlvl.repository.RoleRepository;
import com.qlvl.service.RoleService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository RoleRepo;
    @Override
    public List<Role> getRole(Map<String, String> params) {
       return this.RoleRepo.getRole(params);
    }
    
}
