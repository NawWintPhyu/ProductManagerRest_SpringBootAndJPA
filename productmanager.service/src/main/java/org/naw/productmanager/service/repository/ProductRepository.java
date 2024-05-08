package org.naw.productmanager.service.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.naw.productmanager.model.Product;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository extends DataAccessManager implements IProductRepository {

	private static final String LIST_ALL_PRODUCT = "product.listAll";
	private static final String GET_PRODUCT_BY_ID = "product.getById";
	private static final String DELETE_PRODUCT_BY_ID = "product.deleteById";

	@Override
	public List<Product> listAll() {
		EntityManagerFactory entityManagerFactory = getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		Query query = entityManager.createNamedQuery(LIST_ALL_PRODUCT);
		List<Product> productList = (List<Product>) query.getResultList();

		entityTransaction.commit();
		entityManager.close();
		entityManagerFactory.close();
		setEnityManagerFactoryNull();
		return productList;
	}

	@Override
	public Product save(Product product) {

		EntityManagerFactory entityManagerFactory = getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		entityManager.persist(product);

		entityTransaction.commit();
		entityManager.close();
		entityManagerFactory.close();
		setEnityManagerFactoryNull();
		return product;
	}

	@Override
	public Product get(Long id) {
		EntityManagerFactory entityManagerFactory = getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		Query query = entityManager.createNamedQuery(GET_PRODUCT_BY_ID);
		query.setParameter(1, id);
		List<Product> productList = (List<Product>) query.getResultList();
		Product product = null;
		if (productList.size() > 0) {
			product = productList.get(0);
		}

		entityTransaction.commit();
		entityManager.close();
		entityManagerFactory.close();
		setEnityManagerFactoryNull();
		return product;
	}

	@Override
	public Integer delete(Long id) {
		EntityManagerFactory entityManagerFactory = getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		Query query = entityManager.createNamedQuery(DELETE_PRODUCT_BY_ID);
		query.setParameter(1, id);
		int deletedRows = query.executeUpdate();
		entityTransaction.commit();
		entityManager.close();
		entityManagerFactory.close();
		setEnityManagerFactoryNull();
		return deletedRows;

	}

	@Override
	public Product edit(Product product) {
		Product updatedProduct = null;
		updatedProduct = get(product.getId());
		EntityManagerFactory entityManagerFactory = getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		if (product != null && product.getId() != null) {

			if (product.getBrand() != null) {
				updatedProduct.setBrand(product.getBrand());
			}
			if (product.getMadein() != null) {
				updatedProduct.setMadein(product.getMadein());
			}
			if (product.getName() != null) {
				updatedProduct.setName(product.getName());
			}
			if (product.getPrice() != null) {
				updatedProduct.setPrice(product.getPrice());
			}
			updatedProduct = entityManager.merge(updatedProduct);

		}

		entityTransaction.commit();
		entityManager.close();
		entityManagerFactory.close();
		setEnityManagerFactoryNull();
		return updatedProduct;
	}

}
