package com.marcosoft.marcosoftcustomerexample.controller;

import com.marcosoft.marcosoftcustomerexample.model.Customer;
import com.marcosoft.marcosoftcustomerexample.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customer")
@AllArgsConstructor
public class CustomerController {

    CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> save(@RequestBody Customer newCustomer){
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(newCustomer));
    }

}
