package com.products.services.boot.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.products.services.boot.models.dao.ProductDao;
import com.products.services.boot.models.entity.Product;


//Estereotipo de Component que permite marcar como bean de Spring
@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductDao productDao; 
	
	@Override
	@Transactional(readOnly = true)
	public List<Product> findAll() {
		return (List<Product>) productDao.findAll();
	}

	@Override
	public Product findById(Long id) {
		return productDao.findById(id).orElse(null);
	}

}
