package com.lvg.demo.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lvg.demo.entity.Customers;
import com.lvg.demo.service.CustomersService;
//@Controller
@RestController
@RequestMapping("/customer")
public class CustomersController {
	@Autowired
	CustomersService customerService;
	@GetMapping(value="/")
	public ResponseEntity<List<Customers>> findAllCustomers(){
		//return customerService.findAllCustomers();
		return new ResponseEntity<List<Customers>> (customerService.findAllCustomers(),HttpStatus.OK);
		//return new ResponseEntity<List<Product>>(productService.getAllProducts(),HttpStatus.OK);
	}
	@GetMapping(value="/{customerId}")
	public ResponseEntity<Customers> findCustomersById( @PathVariable int customerId){
		//return customerService.findCustomersById(customerId);
		Customers c=customerService.findCustomersById(customerId);
		if(c!=null) {
			return new ResponseEntity<Customers> (c,HttpStatus.OK);
			
		}else {
			return new ResponseEntity<Customers> (c,HttpStatus.NO_CONTENT);
		}
		
		//Product p=productService.getProductById(productId);
//		if(p!=null) {
//		       return new ResponseEntity<Product> (p,HttpStatus.OK);
//		}else {
//	          return	new  ResponseEntity<Product> (p,HttpStatus.NO_CONTENT);
//		}
	}
	@GetMapping(value="/customerName/{customerName}")
	public Customers findCustomersName(@PathVariable String customerName) {
		return customerService.findCustomerName(customerName);
	}
	
	@PostMapping(consumes="application/json")
	public boolean insertOrModify(@RequestBody Customers customers) {
		
		return customerService.insertOrModifyCustomers(customers);
			
	}
	
	@DeleteMapping(value="/{customerId}")
	public boolean deleteCustomerById(@PathVariable int customerId) {
		return customerService.deleteCustomerById(customerId);
			//return HttpStatus.OK;
	
		
	}
}