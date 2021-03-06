package com.Customer.Controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	public ResponseEntity<Customers> postCustomers(@Valid @RequestBody Customers customer) {
		Customers savedCust = customerService.postCust(customer);
		return new ResponseEntity<Customers>(savedCust, HttpStatus.CREATED);
	}
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customers> getCustomerById(@PathVariable Long id) {
		return customerService.getById(id);
	}
	@PutMapping("/customers/{id}")
	public ResponseEntity<Customers> updateCustomerById(@PathVariable Long id, @RequestBody Customers customer){
		return customerService.updateCustomer(id, customer);
	}
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCustomer(@PathVariable Long id){
		return customerService.deleteCustomer(id);
	}

}
