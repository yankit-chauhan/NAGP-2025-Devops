package com.nagarro.productservice.services.impl;

import com.nagarro.productservice.api.exceptions.ProductNotFoundException;
import com.nagarro.productservice.dto.ProductDataDto;
import com.nagarro.productservice.mappers.ProductMapper;
import com.nagarro.productservice.repo.ProductRepository;
import com.nagarro.productservice.services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static com.nagarro.productservice.constants.ProductConstants.PRODUCT_NOT_FOUND_MESSAGE;

/**
 * This class overrides the {@link ProductService} interface.
 *
 * @author yankitchauhan
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;
  private final ProductMapper productMapper;

  /**
   * {@inheritDoc}
   */
  @Override
  public ProductDataDto getProductById(Long id) {
    var product = productRepository.findById(id);
    if (product.isEmpty()) {
      throw new ProductNotFoundException(String.format(PRODUCT_NOT_FOUND_MESSAGE, id));
    }
    log.info("Product found: " + product);
    return productMapper.mapProductToProductDataDto(product.get());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<ProductDataDto> getAllProducts() {
    var products = productRepository.findAll();
    if (CollectionUtils.isEmpty(products)) {
      throw new ProductNotFoundException("Sorry, We ran out of products.");
    }
    return productMapper.mapProductListToProductDataDtoList(products);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ProductDataDto addProduct(ProductDataDto productDataDto) {
    var product = productMapper.mapProductDataDtoToProduct(productDataDto);
    var addedProduct = productRepository.save(product);
    return productMapper.mapProductToProductDataDto(addedProduct);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ProductDataDto updateProduct(Long id, ProductDataDto productDataDto) {
    if (!productRepository.existsById(id)) {
      throw new ProductNotFoundException(String.format(PRODUCT_NOT_FOUND_MESSAGE, id));
    }
    var product = productMapper.mapProductDataDtoToProduct(productDataDto);
    product.setId(id);

    var updatedProduct = productRepository.save(product);
    return productMapper.mapProductToProductDataDto(updatedProduct);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void deleteProductById(Long id) {
    if (!productRepository.existsById(id)) {
      throw new ProductNotFoundException(String.format(PRODUCT_NOT_FOUND_MESSAGE, id));
    }
    productRepository.deleteById(id);
  }

}
