package com.blit.petAdoption.Controller;

import com.blit.petAdoption.Entity.Pets;
import com.blit.petAdoption.Service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("pets")
public class PetController {

    @Autowired
    PetService petService;

    @GetMapping("/available")
    public ResponseEntity<List<Pets>> viewAllPets(Boolean active){
        return new ResponseEntity<>(petService.viewAllPets(active), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Pets>> viewAllPets(){
        return new ResponseEntity<>(petService.viewAllPets(), HttpStatus.OK);
    }



}
