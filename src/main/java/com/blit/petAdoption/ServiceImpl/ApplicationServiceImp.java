package com.blit.petAdoption.ServiceImpl;

import com.blit.petAdoption.Entity.Application;
import com.blit.petAdoption.Repository.ApplicationRepo;
import com.blit.petAdoption.Service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class ApplicationServiceImp implements ApplicationService {

    @Autowired
    ApplicationRepo applicationRepo;
    @Override
    public List<Application> reviewAllApplications() {

        return(List<Application>) applicationRepo.findAll() ;
    }

    @Override
    public Application reviewApplicationById(Long id) {

        Optional<Application>  optionalApplication = applicationRepo.findById(id);
        if(optionalApplication.isPresent()){
            return optionalApplication.get();
        }else {
            throw new NoSuchElementException("Application with id "+id+" not exist. ");
        }

    }




}
