package com.blit.petAdoption.Controller;

import com.blit.petAdoption.Entity.Pets;
import com.blit.petAdoption.Service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pets")
public class PetController {

    @Autowired
    PetService petService;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePet(@PathVariable Long id){
        petService.deletePet(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
