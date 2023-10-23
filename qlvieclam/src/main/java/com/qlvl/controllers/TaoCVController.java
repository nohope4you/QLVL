/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.controllers;

import com.itextpdf.text.DocumentException;
import com.qlvl.components.PdfGenerator;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Admin
 */
@Controller
public class TaoCVController {
     @Autowired
    private PdfGenerator pdfGenerator;
      @GetMapping("/TaoCV")
    public String TaoCV(){
        return "TaoCV";
    }
     @PostMapping("/TaoCV")
    public ModelAndView generateCV(@RequestParam String name,@RequestParam String tuoi,@RequestParam String mota,
            @RequestParam String school, @RequestParam String GPA,@RequestParam MultipartFile img)throws FileNotFoundException, IOException {
        try {
            String filepath = "D:\\FileCV.pdf";
            pdfGenerator.generatPdfCV(filepath,name,tuoi,mota,school,GPA,img);
            return new ModelAndView("pdfGenerated");
        } catch (DocumentException e) {
            e.printStackTrace();
            return new ModelAndView("pdfGenerationError");
        }
    }
}
