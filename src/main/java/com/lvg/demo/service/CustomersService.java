package com.lvg.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lvg.demo.entity.Customers;
import com.lvg.demo.exception.CustomersNotFoundException;
import com.lvg.demo.repository.CustomersRepository;

@Service
public class CustomersService {
	@Autowired
	CustomersRepository customerRepository;
	
	//@Transactional(readOnly=true)
	public List<Customers> findAllCustomers() throws CustomersNotFoundException {
		List<Customers> clist=customerRepository.findAll();
		if(!clist.isEmpty())
			return clist;
		throw new CustomersNotFoundException("Customer not Found");
	}
	public Customers findCustomersById(int customerId)  throws CustomersNotFoundException{
		Optional<Customers> op= customerRepository.findById(customerId);
		if(op.isPresent())
			return op.get();
		throw new CustomersNotFoundException("Customer id is not found");
		
	}
	public Customers findCustomerName(String customerName) throws CustomersNotFoundException{
		Optional<Customers>cname=customerRepository.findByCustomerName(customerName);
		if(cname.isPresent()) 
			return cname.get();
		throw new CustomersNotFoundException("Customer name is not found");
			
		
	}
	public boolean insertOrModifyCustomers(Customers customers) {
		Customers c=customerRepository.save(customers);
		return c!=null;
	}
	
	public boolean deleteCustomerById(int customerId) throws CustomersNotFoundException{
		long count=customerRepository.count();
		customerRepository.deleteById(customerId);
		if( count>customerRepository.count())
			return true;
	   throw new CustomersNotFoundException("Deleted successfully");
	}

}
