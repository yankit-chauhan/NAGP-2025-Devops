package com.nagarro.productservice.api.controllers;

import com.nagarro.productservice.api.ProductDataApi;
import com.nagarro.productservice.dto.ProductDataDto;
import com.nagarro.productservice.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This class implements the {@link ProductDataApi} interface.
 *
 * @author yankitchauhan
 */
@RestController
@RequiredArgsConstructor
public class ProductController implements ProductDataApi {

  private final ProductService productService;

  /**
   * {@inheritDoc}
   */
  @Override
  public ResponseEntity<ProductDataDto> getProductById(Long id) {
    return ResponseEntity.ok(productService.getProductById(id));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ResponseEntity<List<ProductDataDto>> getAllProducts() {
    return ResponseEntity.ok(productService.getAllProducts());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ResponseEntity<ProductDataDto> addProduct(ProductDataDto productDataDto) {
    return new ResponseEntity<>(productService.addProduct(productDataDto), HttpStatus.CREATED);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ResponseEntity<ProductDataDto> updateProduct(Long id, ProductDataDto productDataDto) {
    return ResponseEntity.ok(productService.updateProduct(id, productDataDto));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ResponseEntity<String> deleteProductById(Long id) {
    productService.deleteProductById(id);
    return ResponseEntity.ok("Product with id: " + id + " deleted.");
  }

}
