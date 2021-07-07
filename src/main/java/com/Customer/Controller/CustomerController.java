package com.Customer.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Customer.Model.Customers;
import com.Customer.Service.CustomerService;

@RestController()
@RequestMapping("/api/v1")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customers> getAllEmployees(){
		return customerService.getAll();
	}
	

}
