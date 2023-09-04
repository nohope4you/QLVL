/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.qlvl.repository;

import com.qlvl.pojo.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface UserRepository {
    User getUserByUserName(String username);
     boolean addUser(User u);
    User getUserById(int id);
    User findUserByUserName(String username);
    List<User> getUsername(Map<String,String> params);
    List<User> getUsernameCriteria(Map<String,String> params);
    boolean authUser(String username, String password);
   }
