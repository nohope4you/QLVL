/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.qlvl.pojo.Role;
import com.qlvl.pojo.User;
import com.qlvl.repository.SignUpRepository;
import com.qlvl.service.SignUpService;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private SignUpRepository Repo;

    @Override
    public boolean addUser(User u) {
        if (!u.getFile().isEmpty()) {
            try {
                Map ress = this.cloudinary.uploader().upload(u.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                u.setAvatar(ress.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(SignUpServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this.Repo.addUser(u);
    }

    @Override
    public User findUserByUsername(String username) {
       return this.Repo.findUserByUsername(username);
    }

}
