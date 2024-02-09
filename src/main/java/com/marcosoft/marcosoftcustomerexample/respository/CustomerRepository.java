package com.marcosoft.marcosoftcustomerexample.respository;

import com.marcosoft.marcosoftcustomerexample.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="customerClient", url = "http://localhost:8081/")
public interface CustomerRepository {

    @PostMapping(value = "customer", consumes = "application/json", produces = "application/json")
    Customer create(@RequestBody Customer newCustomer);

    @GetMapping(value = "customer/{id}", consumes = "application/json", produces = "application/json")
    Customer findById(@PathVariable Long id);

    @GetMapping(value = "customer/all", consumes = "application/json", produces = "application/json")
    List<Customer> findAll();

    @PutMapping(value = "customer", consumes = "application/json", produces = "application/json")
    Customer update(@RequestBody Customer customer);

    @DeleteMapping(value = "customer/{id}", consumes = "application/json", produces = "application/json")
    void deleteById(@PathVariable Long id);

}
