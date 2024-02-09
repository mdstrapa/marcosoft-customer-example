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
        return customerService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("all")
    public ResponseEntity<List<Customer>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.findAll());
    }

    @PutMapping()
    public ResponseEntity<Customer> update(@RequestBody Customer customer){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.update(customer));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        customerService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
    }

}
