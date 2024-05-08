package org.naw.productmanager.rest.controller;

import java.util.List;

import org.naw.productmanager.model.Product;
import org.naw.productmanager.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	IProductService productService;

	@GetMapping
	public ResponseEntity<Object> getAllList() {
		List<Product> productList = productService.listAll();
		return new ResponseEntity<Object>(productList, HttpStatus.OK);
	}

	@PostMapping("/newproduct")
	public ResponseEntity<Object> create(@RequestBody Product product) {
		product = productService.save(product);
		return new ResponseEntity<Object>(product, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getById(@PathVariable(value = "id") Long id) {
		Product product = productService.get(id);
		return new ResponseEntity<Object>(product, HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Long id) {
		Integer deletedRows = productService.delete(id);
		return new ResponseEntity<Object>(deletedRows, HttpStatus.OK);
	}

	@PutMapping("/edit")
	public ResponseEntity<Object> edit(@RequestBody Product product) {
		product = productService.edit(product);
		return new ResponseEntity<Object>(product, HttpStatus.OK);

	}

}
