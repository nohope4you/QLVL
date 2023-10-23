/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.components;

import com.qlvl.pojo.Job;
import com.qlvl.service.JobService;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Admin
 */
@Component
public class ExcelWriter {

    @Autowired
    private JobService jobSer;

    public void writeDataToExcel(String filePath) throws FileNotFoundException, IOException {
        Workbook workbook = WorkbookFactory.create(true);
        org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet("Sheet 1");
        Row headerRow = sheet.createRow(0);
        int rowNumber = 1;
        List<Job> listJob = this.jobSer.getJob(null);
        for (Job j : listJob) {
            Row row = sheet.createRow(rowNumber++);
            row.createCell(0).setCellValue(j.getId().toString());
            row.createCell(1).setCellValue(j.getNameJob());
            row.createCell(2).setCellValue(j.getSalary());
            row.createCell(3).setCellValue(j.getAge().toString());
            row.createCell(4).setCellValue(j.getCityID().getNameCity());
            row.createCell(5).setCellValue(j.getDistricID().getNameDistrict());
            row.createCell(6).setCellValue(j.getTypeJobID().getNameType());
            row.createCell(7).setCellValue(j.getMajorID().getNameMajor());
            row.createCell(8).setCellValue(j.getEducationID().getTypeEducation());
            row.createCell(9).setCellValue(j.getCreatedDate().toString());
        }
        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            workbook.write(outputStream);
        }
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("Name Job");
        headerRow.createCell(2).setCellValue("Salary");
        headerRow.createCell(3).setCellValue("Age");
        headerRow.createCell(4).setCellValue("City");
        headerRow.createCell(5).setCellValue("Distict");
        headerRow.createCell(6).setCellValue("Type Job");
        headerRow.createCell(7).setCellValue("Major");
        headerRow.createCell(8).setCellValue("Education");
        headerRow.createCell(9).setCellValue("Created Date");
        
    }
}
