/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.qlvl.pojo.Role;

import com.qlvl.pojo.User;
import com.qlvl.repository.UserRepository;
import com.qlvl.service.UserService;
import java.io.IOException;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
@Service("userDetailsService")
public class UserServiceImpl implements UserService {
    
        @Autowired
    private BCryptPasswordEncoder passEncoder;
        
    @Autowired
    private UserRepository UserRepo;

    @Autowired
    private Cloudinary cloudinary;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = this.UserRepo.getUserByUserName(username);
        if (u == null) {
            throw new UsernameNotFoundException("msg");
        }
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(u.getUserRole()));

        return new org.springframework.security.core.userdetails.User(
                u.getUsername(), u.getPassword(), authorities);
    }

    @Override
    public boolean addUser(User u) {

//        if (!u.getFile().isEmpty()) {
//            try {
//                Map res = this.cloudinary.uploader().upload(u.getFile().getBytes(),
//                        ObjectUtils.asMap("resource_type", "auto"));
//                  u.setAvatar(res.get("secure_url").toString());
//            } catch (IOException ex) {
//                Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//            }
//             
//        }
        return this.UserRepo.addUser(u);
    }

    @Override
    public List<User> getUsername(Map<String, String> params) {
        return this.UserRepo.getUsername(params);
    }

    @Override
    public User getUserById(int id) {
        return this.UserRepo.getUserById(id);
    }

    @Override
    public List<User> getUsernameCriteria(Map<String, String> params) {
     return this.UserRepo.getUsernameCriteria(params);
    }

    @Override
    public boolean authUser(String username, String password) {
         return this.UserRepo.authUser(username, password);
    }
        @Override
    public User getUserByUn(String username) {
        return this.UserRepo.getUserByUserName(username);
    }

    @Override
    public User addUserJwt(Map<String, String> params, MultipartFile avatar) {
        User u = new User();
        int x= Integer.parseInt( params.get("roleID"));
        Role id = new Role(x);
       
        u.setUsername(params.get("username"));
        u.setHo(params.get("ho"));
        u.setTen(params.get("ten"));
        u.setNamKinhNghiem(Integer.valueOf( params.get("namKinhNghiem")));
        u.setTuoi(Integer.valueOf(params.get("tuoi")));
        u.setEmail(params.get("email"));
        u.setSdt(params.get("sdt"));
        u.setPassword(this.passEncoder.encode(params.get("password")));
        u.setNganhNghe(params.get("NganhNghe"));
        u.setRoleID(id);
        u.setUserRole("ROLE_USER");
                if (!avatar.isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(avatar.getBytes(), 
                        ObjectUtils.asMap("resource_type", "auto"));
                u.setAvatar(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        this.UserRepo.addUser(u);
        return u;
    }

}
