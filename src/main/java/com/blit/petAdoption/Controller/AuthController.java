package com.blit.petAdoption.Controller;


import com.blit.petAdoption.Entity.Customer;
import com.blit.petAdoption.Entity.Role;
import com.blit.petAdoption.LoginDto;
import com.blit.petAdoption.Repository.CustomerRepo;
import com.blit.petAdoption.Repository.RoleRepo;
import com.blit.petAdoption.ServiceImpl.CustomerRetrievalImpl;
import com.blit.petAdoption.SignUpDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    CustomerRetrievalImpl customerRetrievalImpl;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginDto loginDto) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginDto.getUsernameOrEmail(), loginDto.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            return new ResponseEntity<Customer>(customerRetrievalImpl.findByUsernameOrCreate(loginDto.getUsernameOrEmail()), HttpStatus.OK);
        } catch (BadCredentialsException ex) {
            // Handle bad credentials here and return an error response
            return new ResponseEntity<String>("Invalid username or password", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto){

        // add check for username exists in a DB
        if(customerRepo.existsByUsername(signUpDto.getUsername())){
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        // add check for email exists in DB
        if(customerRepo.existsByEmail(signUpDto.getEmail())){
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

        // create user object
        Customer customer = new Customer();
        customer.setFirstName(signUpDto.getName());
        customer.setUsername(signUpDto.getUsername());
        customer.setEmail(signUpDto.getEmail());
        customer.setPassword(passwordEncoder.encode(signUpDto.getPassword()));

        Role roles =  roleRepo.findByName("ROLE_USER").get();
        customer.setRoles(Collections.singleton(roles));

        customerRepo.save(customer);

        return new ResponseEntity<>("Customer registered successfully", HttpStatus.OK);




}}
