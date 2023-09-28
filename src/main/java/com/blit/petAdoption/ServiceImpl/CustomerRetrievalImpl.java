package com.blit.petAdoption.ServiceImpl;

import com.blit.petAdoption.Entity.Customer;
import com.blit.petAdoption.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerRetrievalImpl  {

   private CustomerRepo customerRepo;

    public CustomerRetrievalImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }






    public Customer findByUsername(String username) throws UsernameNotFoundException {
            Optional<Customer> customerOptional = customerRepo.findByUsername(username);

            if (customerOptional.isPresent()) {

                return customerOptional.get();
            } else {
                throw new ResourceNotFoundException("Customer with " + username + " not found");

            }
    }
}
