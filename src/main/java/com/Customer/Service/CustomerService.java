package com.Customer.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Customer.Model.Customers;
import com.Customer.Repositories.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepo;
	//get all
	public List<Customers> getAll(){
		return customerRepo.findAll();
	}
	//post
	public Customers postCust(Customers customer) {
		return customerRepo.save(customer);
	}

}
