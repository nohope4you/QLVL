/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.controllers;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.qlvl.components.PdfGenerator;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Admin
 */
@Controller
public class PdfController {

    @Autowired
    private PdfGenerator pdfGenerator;

    @GetMapping("/generate")
    public ModelAndView generatePdf( String data) throws FileNotFoundException {
        try {
            String filepath = "D:\\ListJob.pdf";
            pdfGenerator.generatPdf(filepath);
            return new ModelAndView("pdfGenerated");
        } catch (DocumentException e) {
            e.printStackTrace();
            return new ModelAndView("pdfGenerationError");
        }
    }
   
    
  
}
