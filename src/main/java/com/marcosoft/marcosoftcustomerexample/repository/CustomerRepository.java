package com.marcosoft.marcosoftcustomerexample.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marcosoft.marcosoftcustomerexample.client.CustomerClient;
import com.marcosoft.marcosoftcustomerexample.model.Customer;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class CustomerRepository {

    CustomerClient client = new CustomerClient();
    ObjectMapper mapper = new ObjectMapper();

    public Customer save(Customer newCustomer){
        try {
            String requestBody = mapper.writeValueAsString(newCustomer);
            HttpRequest request = client.buildRequest("POST","customer", requestBody);
            HttpResponse<String> response = client.sendRequest(request);
            if(response!=null){
                if(response.statusCode()==201){
                    return mapper.readValue(response.body(),Customer.class);
                }
            }

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public Customer findById(Long id){
        HttpRequest request = client.buildRequest("GET","customer/" + id,"");
        HttpResponse<String> response = client.sendRequest(request);
        if(response!=null){
            if(response.statusCode()==200){
                try {
                    return mapper.readValue(response.body(),Customer.class);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return null;
    }

    public List<Customer> findAll(){
        HttpRequest request = client.buildRequest("GET","customer/all","");
        HttpResponse<String> response = client.sendRequest(request);
        if(response!=null){
            if(response.statusCode()==200){
                try {
                    return mapper.readValue(response.body(),new TypeReference<List<Customer>>(){});
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return null;
    }

    public Customer update(Customer customer){
        try {
            String requestBody = mapper.writeValueAsString(mapper);
            HttpRequest request = client.buildRequest("PUT","customer", requestBody);
            HttpResponse<String> response = client.sendRequest(request);
            if(response!=null){
                if(response.statusCode()==200){
                    return mapper.readValue(response.body(),Customer.class);
                }
            }

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public boolean delete(Long id){
        HttpRequest request = client.buildRequest("DELETE", "customer/" + id, "");
        HttpResponse<String> response = client.sendRequest(request);
        if (response != null) {
            if (response.statusCode() == 200) return true;
        }
        return false;
    }

}
