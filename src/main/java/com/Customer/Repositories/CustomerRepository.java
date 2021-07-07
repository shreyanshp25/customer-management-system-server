package com.Customer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Customer.Model.Customers;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, Long> {

}
