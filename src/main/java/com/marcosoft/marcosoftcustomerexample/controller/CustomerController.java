package com.marcosoft.marcosoftcustomerexample.controller;

import com.marcosoft.marcosoftcustomerexample.model.Customer;
import com.marcosoft.marcosoftcustomerexample.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
@AllArgsConstructor
public class CustomerController {

    CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> save(@RequestBody Customer newCustomer){
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(newCustomer));
    }

    @GetMapping("{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.findById(id));
    }

    @GetMapping("all")
    public ResponseEntity<List<Customer>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.findAll());
    }

}
