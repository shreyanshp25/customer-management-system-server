package com.Customer.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Customer.Exceptions.ResourceNotFound;
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
	//get by id
	public ResponseEntity<Customers> getById(Long id) {
		Customers customer = customerRepo.findById(id).orElseThrow(() -> new ResourceNotFound("Customer doesn't exist"+ id));
		return ResponseEntity.ok(customer);
	}
	//update an entry
	public ResponseEntity<Customers> updateCustomer(Long id, Customers customer) {
		Customers cust = customerRepo.findById(id).orElseThrow(() -> new ResourceNotFound("Customer to be updated doesn't exist"+ id));
		cust.setFirstName(customer.getFirstName());
		cust.setLastName(customer.getLastName());
		cust.setEmailId(customer.getEmailId());
		
		Customers updatedCustomer = customerRepo.save(cust);
		return ResponseEntity.ok(updatedCustomer);
	}

}
