package com.blit.petAdoption.Controller;

import com.blit.petAdoption.Entity.Application;
import com.blit.petAdoption.Service.ApplicationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Application")
public class ApplicationController {
    @Autowired
    ApplicationServices applicationServices;

     @GetMapping("/available")
        public ResponseEntity<List<Application>> EmployeeCanSeeAllApplication(){
            return new ResponseEntity<>(applicationServices.EmployeeCanSeeAllApplication(), HttpStatus.OK);
        }
}

