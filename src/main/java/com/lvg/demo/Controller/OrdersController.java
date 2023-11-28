package com.lvg.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lvg.demo.entity.Orders;
import com.lvg.demo.service.OrdersService;
//@Controller
@RestController
@RequestMapping("/orders")
public class OrdersController {
	@Autowired
	OrdersService ordersService;
	@GetMapping(produces="application/json")
	public ResponseEntity<List<Orders>> getAllOrders(){
		return new ResponseEntity<List<Orders>> (ordersService.findAllOrders(),HttpStatus.OK);
	}
	@GetMapping(value="/{orderId}",produces="application/json")
	public ResponseEntity<Orders> getOrdersById(@PathVariable int orderId){
		return new ResponseEntity<Orders>(ordersService.getOrdersById(orderId),HttpStatus.OK);	
	}
	@GetMapping(value="/customer/{customerId}",produces="application/json")
	public ResponseEntity<Orders> getOrdersByCustomersId(@PathVariable int customerId){
		return new ResponseEntity<Orders> (ordersService.getCustomersById(customerId),HttpStatus.OK);
	}
}