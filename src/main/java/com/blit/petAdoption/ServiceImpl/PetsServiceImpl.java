package com.blit.petAdoption.ServiceImpl;

import com.blit.petAdoption.Entity.Application;
import com.blit.petAdoption.Entity.Customer;
import com.blit.petAdoption.Entity.Pets;
import com.blit.petAdoption.Repository.PetRepo;
import com.blit.petAdoption.Service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    @Override
    public Pets retrievePetById(Long id) {
        Optional<Pets> petsOptional = petRepo.findById(id);

        if(petsOptional.isPresent()) {
            return petsOptional.get();
        }else{
            throw new RuntimeException("Pet with "+ id +" not found");
        }
    }

    @Override
    public Pets addPet(Pets pet) {
        return petRepo.save(pet);
    }

    @Override
    public Pets AdoptAPet(Long petId, Customer customer) {
        Optional<Pets> petsOptional = petRepo.findById(petId);

        if (petsOptional.isPresent()) {
            Pets pet = petsOptional.get();
            Set<Application> applications = pet.getApplication();

            // Create a new Application object and associate it with the customer
            Application application = new Application();
            application.setCustomer(customer);

            // Add the new Application to the existing set of applications
            applications.add(application);

            // Update the pet's applications
            pet.setApplication(applications);

            // Save the updated pet
            petRepo.save(pet);

            return pet;
        } else {
            throw new ResourceNotFoundException("Pet with id " + petId + " does not exist");
        }
    }


    @Override
    public Pets updatePet(Long id, Pets pet) {

        Optional<Pets> petsOptional = petRepo.findById(id);

        if(petsOptional.isPresent()) {
            petsOptional.get().setAge(pet.getAge());
            petsOptional.get().setSex(pet.getSex());
            petsOptional.get().setName(pet.getName());
            petsOptional.get().setColor(pet.getColor());
            petsOptional.get().setBreed(pet.getBreed());
            petsOptional.get().setPetType(pet.getPetType());

            petRepo.save(petsOptional.get());
            return petsOptional.get();
        }else{
            throw new ResourceNotFoundException("Pet with id "+id+ "does not exist");
        }
    }

    @Override
    public void deletePet(Long id) {

        Optional<Pets> petsOptional = petRepo.findById(id);
        if(petsOptional.isPresent()){
            petRepo.deleteById(id);
        }else {
            throw new ResourceNotFoundException("Pet with id "+id+ "does not exist");
        }

    }
}
