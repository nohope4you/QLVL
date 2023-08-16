/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.formatters;


import com.qlvl.pojo.Major;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Admin
 */
public class MajorFormatter implements Formatter<Major>{
     @Override
    public String print(Major ct, Locale locale) {
      return String.valueOf(ct.getId());
    }

    @Override
    public Major parse(String ctId, Locale locale) throws ParseException {
      int id =Integer.parseInt(ctId);
      return new Major(id);
    }
}
