package com.bank.bankapp.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.bankapp.model.Account;
import com.bank.bankapp.model.Customer;
import com.bank.bankapp.repositories.CustomerRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="Customers")
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@RequestMapping(method = RequestMethod.GET,value="/customers")
	@ApiOperation(value="list of customers")
	public List<Customer> getCustomers()
	{
		List<Customer> customers = new ArrayList<Customer>();
		customerRepository.findAll().forEach(customers::add);
		return customers;
	}
	
	
	  @RequestMapping(method = RequestMethod.GET,value="/customers/{id}")
	  @ApiOperation(value="list of customers by id")
	  public Optional<Customer> getCustomer(@PathVariable int id) 
	  { 
		  Optional<Customer> customer=customerRepository.findById(id);
			  return customer; 
	  }
	  
	  @RequestMapping(method=RequestMethod.POST,value="/customers")
	  @ApiOperation(value="Add customer")
	  public ResponseEntity<String> addCustomer(@RequestBody Customer customer) 
	  {
		  	customer.setAccount(new Account());	
			customerRepository.save(customer);
			return new ResponseEntity<>("Customer added successfully",HttpStatus.OK);
		  
	  }
	  
	  @RequestMapping(method=RequestMethod.PUT,value="/customers/{id}")
	  @ApiOperation(value="update a customer")
	  public ResponseEntity<String> updateCustomer(@RequestBody Customer customer,@PathVariable int id) 
	  {
		  Optional<Customer> cus=customerRepository.findById(id);
			 if(cus.isPresent())
			 {
				 Customer cusnew=cus.get();
				 cusnew.setName(customer.getName());
				 cusnew.setEmail(customer.getEmail());
				 cusnew.setPhone(customer.getPhone());
				 customerRepository.save(cusnew);
				 return new ResponseEntity<>("customer values are updated",HttpStatus.OK);
			 }
			 else
			 {
				 return new ResponseEntity<>("cannot update the customer details",HttpStatus.BAD_REQUEST);
			 }
	  }
	  
	  @RequestMapping(method=RequestMethod.DELETE,value="/customers/{id}")
	  @ApiOperation(value="Delete customer")
	  public ResponseEntity<String> deleteCustomer(@PathVariable int id) 
	  {  
		  Optional<Customer> customer=customerRepository.findById(id);
		  if(customer.isPresent())
		  {
			  customerRepository.deleteById(id); 
			  return new ResponseEntity<>("customer deleted successfully",HttpStatus.BAD_REQUEST);
		  }
		  else
		  {
			  return new ResponseEntity<>("customer is not present",HttpStatus.BAD_REQUEST);
		  }
	  }
	  
	  
}
