package com.blit.petAdoption.ServiceImpl;

import com.blit.petAdoption.Entity.Pets;
import com.blit.petAdoption.Repository.PetRepo;
import com.blit.petAdoption.Service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetsServiceImpl implements PetService {

    @Autowired
    PetRepo petRepo;

    @Override
    public List<Pets> viewAvailPets() {
        return  petRepo.displayActivePets();
    }
   @Override
    public List<Pets> viewAllPets() {
        return (List<Pets>) petRepo.findAll();
    }
}
