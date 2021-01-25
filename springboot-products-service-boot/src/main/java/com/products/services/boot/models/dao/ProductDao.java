package com.products.services.boot.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.products.services.boot.models.entity.Product;



public interface ProductDao extends CrudRepository<Product, Long> {
	
	
	

}
