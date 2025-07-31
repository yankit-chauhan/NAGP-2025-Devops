package com.nagarro.productservice.repo;

import com.nagarro.productservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface declares the JPA repository for Product entity.
 *
 * @author yankitchauhan
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}