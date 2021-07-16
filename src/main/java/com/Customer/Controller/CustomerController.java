package com.Customer.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Customer.Model.Customers;
import com.Customer.Service.CustomerService;

@RestController()
@RequestMapping("/api/v1")
@CrossOrigin
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customers> getAllCustomers(){
		return customerService.getAll();
	}
	@PostMapping("/customers")
	public Customers postCustomers(@RequestBody Customers customer) {
		return customerService.postCust(customer);
	}
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customers> getCustomerById(@PathVariable Long id) {
		return customerService.getById(id);
	}
	@PutMapping("/customers/{id}")
	public ResponseEntity<Customers> updateCustomerById(@PathVariable Long id, @RequestBody Customers customer){
		return customerService.updateCustomer(id, customer);
	}

}
