package com.blit.petAdoption.ServiceImpl;

import com.blit.petAdoption.Entity.Application;
import com.blit.petAdoption.Entity.Customer;
import com.blit.petAdoption.Entity.Employee;
import com.blit.petAdoption.Entity.Pets;
import com.blit.petAdoption.Repository.ApplicationRepo;
import com.blit.petAdoption.Repository.CustomerRepo;
import com.blit.petAdoption.Repository.EmployeeRepo;
import com.blit.petAdoption.Repository.PetRepo;
import com.blit.petAdoption.Service.ApplicationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ApplicationServicesImpl implements ApplicationServices {
       @Autowired
       ApplicationRepo applicationRepo;

        @Autowired
        PetRepo petRepo;

        @Autowired
        EmployeeRepo employeeRepo;

        @Autowired
        CustomerRepo customerRepo;
    @Override
    public List<Application> EmployeeCanSeeAllApplication() {
        return applicationRepo.findAll();
    }


    @Override
    public Application createApplication(Application application, Long custId, Long petId) {
        Pets pet = petRepo.findById(petId).orElseThrow(()->new RuntimeException("Pet with the id not found"));
        application.setPets(pet);
        Employee employee = employeeRepo.findById(1L).orElseThrow(()->new RuntimeException("Employee not found"));
        application.setEmployee(employee);
        Customer customer = customerRepo.findById(custId).orElseThrow(()->new RuntimeException("Customer not found"));
        application.setCustomer(customer);
        application.setDate(new Date());
        return applicationRepo.save(application);
    }
}


