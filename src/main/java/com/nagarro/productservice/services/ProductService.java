package com.nagarro.productservice.services;

import com.nagarro.productservice.dto.ProductDataDto;

import java.util.List;

/**
 * Product Service interface.
 *
 * @author yankitchauhan
 */
public interface ProductService {

  /**
   * This method fetches the product data based on id and maps it to product dto.
   *
   * @param id the product id
   * @return product
   */
  ProductDataDto getProductById(Long id);

  /**
   * This method fetches all the product data from database.
   *
   * @return list of product DTOs
   */
  List<ProductDataDto> getAllProducts();

  /**
   * This method is used to add product to database.
   *
   * @param productDataDto the product request DTO
   * @return added product DTO
   */
  ProductDataDto addProduct(ProductDataDto productDataDto);

  /**
   * This method is used to update product based on id in database.
   *
   * @param id             the product id
   * @param productDataDto the product request DTO
   * @return updated product DTO
   */
  ProductDataDto updateProduct(Long id, ProductDataDto productDataDto);

  /**
   * This method is used to delete product based on id.
   *
   * @param id the product id
   */
  void deleteProductById(Long id);

}
