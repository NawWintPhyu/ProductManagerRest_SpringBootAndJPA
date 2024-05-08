package org.naw.productmanager.service.repository;

import java.util.List;

import org.naw.productmanager.model.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository {
	public List<Product> listAll();

	public Product save(Product product);

	public Product get(Long id);

	public Integer delete(Long id);

	public Product edit(Product product);
}
