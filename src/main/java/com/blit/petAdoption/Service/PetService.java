package com.blit.petAdoption.Service;

import com.blit.petAdoption.Entity.Application;
import com.blit.petAdoption.Entity.Customer;
import com.blit.petAdoption.Entity.Employee;
import com.blit.petAdoption.Entity.Pets;

import java.util.List;

public interface PetService {

    List<Pets> viewAvailPets();
    List<Pets> viewAllPets();

    Pets retrievePetById(Long id);

    Pets addPet(Pets pet);

    List<Application> AdoptAPet(Long petId, Customer customer, Employee employee);

    Pets updatePet(Long id, Pets pet);

    void deletePet(Long id);

}
