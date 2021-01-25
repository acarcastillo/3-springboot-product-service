package com.products.services.boot.models.service;

import java.util.List;

import com.products.services.boot.models.entity.Product;



public interface IProductService {

	public List<Product> findAll();

	public Product findById(Long id);

}
