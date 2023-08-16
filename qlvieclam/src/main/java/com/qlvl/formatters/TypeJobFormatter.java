/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.formatters;


import com.qlvl.pojo.Typejob;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Admin
 */
public class TypeJobFormatter implements Formatter<Typejob>{
     @Override
    public String print(Typejob ct, Locale locale) {
      return String.valueOf(ct.getId());
    }

    @Override
    public Typejob parse(String ctId, Locale locale) throws ParseException {
      int id =Integer.parseInt(ctId);
      return new Typejob(id);
    }
}
