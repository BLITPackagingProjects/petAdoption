package com.blit.petAdoption.ServiceImpl;

import com.blit.petAdoption.Entity.Application;
import com.blit.petAdoption.Repository.ApplicationRepo;
import com.blit.petAdoption.Service.ApplicationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ApplicationServicesImpl implements ApplicationServices {
       @Autowired
       ApplicationRepo applicationRepo;
    @Override
    public List<Application> EmployeeCanSeeAllApplication() {
        return applicationRepo.findAll();
    }
}


