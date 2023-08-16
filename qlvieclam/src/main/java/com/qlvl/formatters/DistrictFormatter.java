/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.formatters;


import com.qlvl.pojo.District;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Admin
 */
public class DistrictFormatter implements Formatter<District>{
     @Override
    public String print(District ct, Locale locale) {
      return String.valueOf(ct.getId());
    }

    @Override
    public District parse(String ctId, Locale locale) throws ParseException {
      int id =Integer.parseInt(ctId);
      return new District(id);
    }
}
