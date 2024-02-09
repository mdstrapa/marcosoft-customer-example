package com.marcosoft.marcosoftcustomerexample.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "customer")
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    private String surname;
    private String uf;
}
