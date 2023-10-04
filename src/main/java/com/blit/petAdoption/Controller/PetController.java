package com.blit.petAdoption.Controller;

import com.blit.petAdoption.Entity.Application;
import com.blit.petAdoption.Entity.Customer;
import com.blit.petAdoption.Entity.Employee;
import com.blit.petAdoption.Entity.Pets;
import com.blit.petAdoption.Repository.CustomerRepo;
import com.blit.petAdoption.Repository.EmployeeRepo;
import com.blit.petAdoption.Service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pets")
public class PetController {

    @Autowired
    PetService petService;

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    EmployeeRepo employeeRepo;

    @GetMapping("/available")
    public ResponseEntity<List<Pets>> viewAvailPets(){
        return new ResponseEntity<>(petService.viewAvailPets(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Pets>> viewAllPets(){
        return new ResponseEntity<>(petService.viewAllPets(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pets> viewPetById(@PathVariable Long id){
        return new ResponseEntity<>(petService.retrievePetById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Pets> addPet(@RequestBody Pets pet){
        return new ResponseEntity<>(petService.addPet(pet),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pets> updatePet(@PathVariable Long id, @RequestBody Pets pet){

        Pets updatePet = petService.updatePet(id,pet);
        return new ResponseEntity<>(updatePet, HttpStatus.OK);
    }

    @PostMapping("/{id}/{customerid}/{employeeid}")
    public ResponseEntity<List<Application>> adoptAPet(@PathVariable("id") Long id,
                                          @PathVariable("customerid") Long id1,
                                          @PathVariable("employeeid") Long id2) {
        // This is to test and make sure this method works
        //Customer currentCustomer = new Customer();

//        currentCustomer.setFirstName("John");
//        currentCustomer.setLastName("Doe");
//        currentCustomer.setUsername("johndoe");
//        currentCustomer.setEmail("john.doe@gmail.com");
//        currentCustomer.setPassword("1234");
//
//        customerRepo.save(currentCustomer);
        Employee em1 = new Employee();
        em1.setEmployeeId(1L);
        em1.setFirstName("James");
        em1.setLastName("Connaway");
        em1.setAddress("123 Hill Street");
        em1.setPhone("213-212-2321");
        em1.setUserName("JCon");
        em1.setPassword("2134");

        employeeRepo.save(em1);

        Employee currentEmployee = employeeRepo.findById(id2).orElseThrow(() -> new RuntimeException("data not found"));
        // Call the service method to adopt the pet
        Customer currentCustomer = customerRepo.findById(id1).orElseThrow(() -> new RuntimeException("data not found"));
        List<Application> adoptedPet = petService.AdoptAPet(id, currentCustomer, currentEmployee);
        return new ResponseEntity<>(adoptedPet, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePet(@PathVariable Long id){
        petService.deletePet(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
