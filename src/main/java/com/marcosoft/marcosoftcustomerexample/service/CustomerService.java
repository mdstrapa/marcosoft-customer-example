package com.marcosoft.marcosoftcustomerexample.service;

import com.marcosoft.marcosoftcustomerexample.model.Customer;
import com.marcosoft.marcosoftcustomerexample.respository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    CustomerRepository customerRepository = new CustomerRepository();

    public Customer save(Customer newCustomer){
        return customerRepository.save(newCustomer);
    }

    public Customer findById(Long id){
        return customerRepository.findById(id);
    }

    public List<Customer> findAll(){
        return customerRepository.findAll();
    }
}
