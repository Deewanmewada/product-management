package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.ProductEntity;
import com.product.request.ProductRequest;
import com.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/saveproduct")
	public String saveProduct(@RequestBody ProductRequest request) {
		
		return productService.saveProduct(request);
		
		
	}
	
	//get all product 
	@GetMapping("/viewAll")
	public List<ProductEntity> getAllProduct() {
		List<ProductEntity> res = productService.viewAll();
		
		return  res;
	}
	
	//update product
	@PutMapping("/updateproduct/{id}")
	public String updateProduct(@PathVariable("id") int id, @RequestBody ProductRequest request) {
		return productService.updateProduct(id, request);
	}
	
	//delete
	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable("id") int id) {
		return productService.delete(id);
	}
	
}
