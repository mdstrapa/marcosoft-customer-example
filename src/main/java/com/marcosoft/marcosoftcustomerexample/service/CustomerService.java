package com.marcosoft.marcosoftcustomerexample.service;

import com.marcosoft.marcosoftcustomerexample.model.Customer;
import com.marcosoft.marcosoftcustomerexample.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {

    CustomerRepository customerRepository;

    public Customer save(Customer newCustomer){
        newCustomer.setFirstName(newCustomer.getFirstName().toUpperCase());
        newCustomer.setSurname(newCustomer.getSurname().toUpperCase());
        return customerRepository.save(newCustomer);
    }

    public Optional<Customer> findById(Long id){
        return customerRepository.findById(id);
    }

    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

    public Customer update(Customer customer){
        return customerRepository.save(customer);
    }

    public void delete(Long id){
        customerRepository.deleteById(id);
    }
}
