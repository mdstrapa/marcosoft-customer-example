package com.marcosoft.marcosoftcustomerexample.repository;

import com.marcosoft.marcosoftcustomerexample.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Optional<Customer> findByFirstName(String firstName);

    List<Customer> findByUf(String uf);

}
