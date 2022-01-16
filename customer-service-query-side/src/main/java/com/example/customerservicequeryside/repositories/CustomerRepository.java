package com.example.customerservicequeryside.repositories;

import com.example.customerservicequeryside.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {
}
