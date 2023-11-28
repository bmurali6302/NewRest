package com.lvg.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lvg.demo.entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,Integer>{
	
	Optional<Orders> findByCustomerId(int customerId);

}
