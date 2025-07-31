package com.nagarro.productservice.api;

import com.nagarro.productservice.dto.ProductDataDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * This interface declares the API methods.
 *
 * @author yankitchauhan
 */
public interface ProductDataApi {

  /**
   * API to fetch a product based on product id.
   *
   * @param id the product id
   * @return product
   */
  @GetMapping("/v1/products/{id}")
  ResponseEntity<ProductDataDto> getProductById(@PathVariable Long id);

  /**
   * API to fetch all products.
   *
   * @return list of products
   */
  @GetMapping("/v1/products")
  ResponseEntity<List<ProductDataDto>> getAllProducts();

  /**
   * API to add product.
   *
   * @param productDataDto the product DTO to be added
   * @return the added product
   */
  @PostMapping("/v1/products")
  ResponseEntity<ProductDataDto> addProduct(@RequestBody ProductDataDto productDataDto);

  /**
   * API to update product.
   *
   * @param id             the product id
   * @param productDataDto the product DTO to be updated
   * @return the updated product
   */
  @PutMapping("/v1/products/{id}")
  ResponseEntity<ProductDataDto> updateProduct(@PathVariable Long id,
                                               @RequestBody ProductDataDto productDataDto);

  /**
   * API to delete product.
   *
   * @param id the product id
   * @return successful product deletion message
   */
  @DeleteMapping("/v1/products/{id}")
  ResponseEntity<String> deleteProductById(@PathVariable Long id);

}
