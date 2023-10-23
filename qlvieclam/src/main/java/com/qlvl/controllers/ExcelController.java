/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.controllers;

import com.qlvl.components.ExcelWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Admin
 */
@Controller
public class ExcelController {

    @Autowired
    private ExcelWriter excelWriter;

    @GetMapping("/generateExcel")
    public ModelAndView generatePdf(String data) throws FileNotFoundException {

        try {
            String filepath = "D:\\ListJob.xlsx";
            excelWriter.writeDataToExcel(filepath);
            return new ModelAndView("pdfGenerated");
        } catch (IOException e) {
               return new ModelAndView("pdfGenerationError");
        }

    }

}
