/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.qlvl.service;

import com.qlvl.pojo.Major;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ACER
 */
public interface MajorService {

    List<Major> getMajor();

    Major getMajorById(int id);
}
