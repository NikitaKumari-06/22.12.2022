package com.project.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.model.Product;
import com.project.demo.repository.ProductRepository;

@RestController
@RequestMapping("/api/p1/")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	//add data
	@PostMapping("products")
	public void save(@RequestBody Product product) {
		productRepository.save(product);
	}
	
	//get data of particular id
	@GetMapping("products/{id}")
	public Optional<Product> getById(@PathVariable("id") int id) {
		return productRepository.findById(id);
	}
	
	//update data
	@PutMapping("products/{productid}")
	public void update(@RequestBody Product product,  @PathVariable("productid") int productid) {
		product.setId(productid);
		productRepository.save(product);
	}
	
	//delete data
	@DeleteMapping("products/{id}")
	public void deleteById(@PathVariable("id") int id) {
		productRepository.deleteById(id);
	}

	//get all data
	@GetMapping("products")
	public List<Product> getAll() {
		return productRepository.findAll();
	}
	
	//get data by name using query
	@GetMapping("products/query")
	public Product getByName() {
		return productRepository.findByName();
	}
	
	//get data by names using native query
	@GetMapping("products/native")
	public List<Product> getByNames( String name) {
		return productRepository.findByNames();
	}
	
	//paging implementation
	@GetMapping("products/paging")
	public List<Product> getProducts() {
		org.springframework.data.domain.Pageable pageable = PageRequest.of(0, 2);
		List<Product> list = productRepository.findProducts(pageable);
		
		return list;
	}
	
	//sorting implementation using id
	@GetMapping("products/sorting")
	public List<Product> getAllSortProduct() {
		String sortBy = "id";
		List<Product> list = (List<Product>) productRepository.sortProduct(Sort.by(Sort.Direction.ASC,sortBy));
		
		return list;
	}
}
