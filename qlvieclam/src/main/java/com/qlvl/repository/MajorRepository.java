/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.qlvl.repository;

import com.qlvl.pojo.Major;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ACER
 */
public interface MajorRepository {
    List<Major> getMajor(Map<String,String> params);
}
