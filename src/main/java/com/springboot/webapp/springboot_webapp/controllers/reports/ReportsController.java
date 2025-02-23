package com.springboot.webapp.springboot_webapp.controllers.reports;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports")
public class ReportsController {

    @GetMapping("/pdf")
    public String pdfReport() {
        return "pdfReport";
    }
    @GetMapping("/excel")
    public String excelReport() {
        return "Weekly report";
    }
    @GetMapping("/graphic")
    public String GraphicReport() {
        return "Monthly report";
    }

    
}
