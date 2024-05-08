package org.naw.productmanager.service.repository;

import java.util.List;

import org.naw.productmanager.model.Product;

public class Test extends DataAccessManager {

	public static void main(String[] args) {
		ProductRepository productRepository = new ProductRepository();
		List<Product> productList=productRepository.listAll();

	}

}
