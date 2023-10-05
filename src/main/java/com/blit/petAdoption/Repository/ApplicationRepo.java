package com.blit.petAdoption.Repository;

import com.blit.petAdoption.Entity.Application;
import com.blit.petAdoption.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepo extends JpaRepository<Application, Long> {
    List<Application> findByCustomer(Customer customer);
}
