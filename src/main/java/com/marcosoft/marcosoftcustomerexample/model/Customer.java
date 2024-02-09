package com.marcosoft.marcosoftcustomerexample.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
    private Long id;
    private String firstName;
    private String surname;
    private String uf;
}
