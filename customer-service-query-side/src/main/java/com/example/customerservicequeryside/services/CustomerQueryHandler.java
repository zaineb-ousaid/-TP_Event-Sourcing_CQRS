package com.example.customerservicequeryside.services;


import com.example.customerservicequeryside.entities.Customer;
import com.example.customerservicequeryside.repositories.CustomerRepository;
import com.exemple.coreapi.query.GetAllCustomersQuery;
import com.exemple.coreapi.query.GetCustomerByIdQuery;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class CustomerQueryHandler {
    public CustomerRepository customerRepository;

    @QueryHandler
    public List<Customer> customerList(GetAllCustomersQuery query){
        return customerRepository.findAll();
    }
    @QueryHandler
    public Customer customerList(GetCustomerByIdQuery query){
        return customerRepository.findById(query.getId())
                .orElseThrow(()->new RuntimeException("Customer not found"));
    }
}
