package org.naw.productmanager.service;

import java.util.List;

import org.naw.productmanager.model.Product;
import org.naw.productmanager.service.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

	@Autowired
	IProductRepository productRepository;

	@Override
	public List<Product> listAll() {
		List<Product> productList = productRepository.listAll();

		return productList;
	}

	@Override
	public Product save(Product product) {
		product = productRepository.save(product);
		return product;
	}

	@Override
	public Product get(Long id) {
		Product product = productRepository.get(id);

		return product;
	}

	@Override
	public Integer delete(Long id) {
		Integer deletedRows = productRepository.delete(id);
		return deletedRows;

	}

	@Override
	public Product edit(Product product) {
		product = productRepository.edit(product);
		return product;
	}

}
