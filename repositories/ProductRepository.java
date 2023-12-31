package com.devsuperior.uri2621.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2621.entities.Product;
import com.devsuperior.uri2621.projections.ProductMinProjection;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@Query(nativeQuery = true, value = "SELECT products.name "
			+ "FROM products"
			+ "INNER JOIN providers On products.id_providers=providers.id "
			+ "WHERE products.amount BETWEEN :min AND :max "
			+ "AND providers.name LIKE CONCAT(:biginName, '%') ")
	List<ProductMinProjection> search1(Integer min, Integer max, String biginName);

}
