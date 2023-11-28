package com.lvg.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lvg.demo.entity.Customers;
import com.lvg.demo.entity.Orders;
import com.lvg.demo.exception.OrdersNotFoundException;
import com.lvg.demo.repository.OrdersRepository;
@Service
public class OrdersService {
	@Autowired
	OrdersRepository ordersRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	public List<Orders> findAllOrders(){
		return ordersRepository.findAll();
		
	}
	public Orders getOrdersById(int orderId) throws OrdersNotFoundException  {
		Optional<Orders> op=ordersRepository.findById(orderId);
		if(op.isPresent()) 
			return op.get();
		throw new OrdersNotFoundException("Order is not there"+orderId);
	}
	public Orders getCustomersById(int customerId) {
		Optional<Orders> rev=ordersRepository.findByCustomerId(customerId);
		if(rev.isPresent()) {
			Customers c=restTemplate.getForEntity
					("https://localhost:8092/customer/{customerId}",Customers.class,customerId).getBody();
			Orders r=rev.get();
			r.setCustomers(new com.lvg.demo.dto.Customer());
			r.getCustomers().setCustomerId(customerId);
			r.getCustomers().setCustomerName(c.getCustomerName());
			r.getCustomers().setCustomerEmail(c.getCustomerEmail());
			r.getCustomers().setCustomerDetails(c.getCustomerDetails());
			return r;
		}
		throw new OrdersNotFoundException("Order does not exist with customerId"+customerId);
		
	}
	//490992
//public Reviews getReviewsByProductId(int productId) {
//		
//		Optional<Reviews> optRev=reviewsRepository.findByProductId(productId);
//		if(optRev.isPresent()) 
//		{
//			Product p=restTemplate.getForEntity
//			("http://localhost:8092/product/{productId}",Product.class,productId).getBody();
//			Reviews r=optRev.get();
//			r.setProduct(new com.lvg.rest.dto.Product());
//			r.getProduct().setProductId(productId);
//			r.getProduct().setProductName(p.getProductName());
//			r.getProduct().setProductDescription(p.getProductDescription());
//			r.getProduct().setProductPrice(p.getProductPrice());
//			r.getProduct().setProductQuantity(p.getProductQuantity());
//			
//			return r;
//		}
//		throw new ReviewNotFoundException("Review Does Not exist with ProductId "+productId);	
//		
//	}

}
