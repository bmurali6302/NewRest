package com.lvg.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lvg.demo.entity.Customers;
@Repository
public interface CustomersRepository  extends JpaRepository<Customers,Integer>{
	Optional<Customers> findByCustomerName(String CustomerName);

}
