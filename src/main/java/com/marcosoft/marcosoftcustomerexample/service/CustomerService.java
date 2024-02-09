package com.marcosoft.marcosoftcustomerexample.service;

import com.marcosoft.marcosoftcustomerexample.model.Customer;
import com.marcosoft.marcosoftcustomerexample.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    CustomerRepository customerRepository = new CustomerRepository();

    public Customer save(Customer newCustomer){
        newCustomer.setFirstName(newCustomer.getFirstName().toUpperCase());
        newCustomer.setSurname(newCustomer.getSurname().toUpperCase());
        return customerRepository.save(newCustomer);
    }

    public Customer findById(Long id){
        return customerRepository.findById(id);
    }

    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

    public Customer update(Customer customer){
        return customerRepository.update(customer);
    }

    public void delete(Long id){
        customerRepository.delete(id);
    }
}
