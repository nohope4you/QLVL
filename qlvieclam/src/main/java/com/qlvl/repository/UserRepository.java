/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.qlvl.repository;

import com.qlvl.pojo.User;

/**
 *
 * @author Admin
 */
public interface UserRepository {
    User getUserByUserName(String username);
}
