package com.example.customerservicequeryside.services;

import com.example.customerservicequeryside.entities.Customer;
import com.example.customerservicequeryside.repositories.CustomerRepository;
import com.exemple.coreapi.events.CustomerCreatedEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class CustomerEventHandler {
    private CustomerRepository customerRepository;
    @EventHandler
    public void on(CustomerCreatedEvent event){
        log.info("*************CustomerCreatedEvent received!*************");
        Customer customer=new Customer();
        customer.setId(event.getId());
        customer.setName(event.getName());
        customer.setEmail(event.getEmail());
        customerRepository.save(customer);
    }

}
