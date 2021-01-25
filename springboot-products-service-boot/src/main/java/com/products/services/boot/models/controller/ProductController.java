package com.products.services.boot.models.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.products.services.boot.models.entity.Product;
import com.products.services.boot.models.service.IProductService;


@RestController
public class ProductController {

	@Autowired
	private Environment env;
	
	@Value("${server.port}")
	private Integer port; 
	

	@Autowired
	private IProductService productService;

	@GetMapping("/listar")
	public List<Product> listAll() {
		return productService.findAll().stream().map(product -> {
			//product.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			product.setPort(port);
			return product;
		}).collect(Collectors.toList());
	}

//	@GetMapping("/detail/{id}")
//	public Product productDetail(@PathVariable Long id) {
//		Product product = productService.findById(id);
//		//product.setPort(Integer.parseInt(env.getProperty("local.server.port")));
//		product.setPort(port);
//		return product;
//	}
	
//	@GetMapping("/detail/{id}")
//	public Product productDetail(@PathVariable Long id) throws Exception {
//		Product product = productService.findById(id);
//		//product.setPort(Integer.parseInt(env.getProperty("local.server.port")));
//		product.setPort(port);
//		
//		boolean ok = false; 
//		
//		if (ok==false) {
//			throw new Exception ("No se pudo realizar la consulta");	
//		}
//		return product;
//	}
	
	@GetMapping("/detail/{id}")
	public Product productDetail(@PathVariable Long id){
		Product product = productService.findById(id);
		//product.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		product.setPort(port);
		
		try {
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return product;
	}	
}
