package com.blit.petAdoption.Controller;


import com.blit.petAdoption.Entity.Application;
import com.blit.petAdoption.Entity.Pets;
import com.blit.petAdoption.Service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/Application")
public class ApplicationController {


    @Autowired
    private ApplicationService applicationService;

    @GetMapping("/all")
    public ResponseEntity<List<Application>> reviewAllApplications() {
        return new ResponseEntity<>(applicationService.reviewAllApplications(), HttpStatus.OK);
    }

    // New method to get an application by ID
    @GetMapping("/{id}")
    public ResponseEntity<Application> getApplicationById(@PathVariable Long id) {
        return new ResponseEntity<>(applicationService.reviewApplicationById(id), HttpStatus.OK);

    }}
