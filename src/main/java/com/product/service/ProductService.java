package com.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entity.ProductEntity;
import com.product.repository.ProductRepository;
import com.product.request.ProductRequest;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository repository;
	
	//save product
	public String saveProduct(ProductRequest request) {
		
		ProductEntity entity = new ProductEntity();
		
		entity.setProductName(request.getProductName());
		entity.setQty(request.getQty());
		entity.setPrice(request.getPrice());
		
		ProductEntity respone = repository.save(entity);
		
	
		return "Save successfull  product id: "+ respone.getId() ;
	}
	
	//viewAll
	
	public List<ProductEntity> viewAll(){
		
		List<ProductEntity> products = repository.findAll();
		
		return products ;
	}
	
	//update product
	public String  updateProduct(int id,  ProductRequest request) {
		
		Optional<ProductEntity> optional = repository.findById(id);
		
		if(optional.isPresent()) {
			ProductEntity entity = optional.get();
			
			entity.setProductName(request.getProductName());
			entity.setQty(request.getQty());
			entity.setPrice(request.getPrice());
			
			repository.save(entity);
			return "update successfully .... Id: " + id ;
		}
		return "product not found " ;
	}
	
	// delete
	public String delete(int id) {
		
		Optional<ProductEntity> optional = repository.findById(id);
		
		if(optional.isPresent()) {
			ProductEntity entity = optional.get();
			repository.delete(entity);
			
			return "Deleted successfully id: " + id;
		}
		return "Prouduct not found" ;
		
	}
}
