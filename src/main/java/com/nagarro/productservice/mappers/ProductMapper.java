package com.nagarro.productservice.mappers;

import com.nagarro.productservice.dto.ProductDataDto;
import com.nagarro.productservice.entities.Product;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * This interface defines the methods to convert product object.
 *
 * @author yankitchauhan
 */
@Mapper
public interface ProductMapper {

  /**
   * This method converts product entity to product data dto.
   *
   * @param product the product entity object
   * @return product data dto
   */
  ProductDataDto mapProductToProductDataDto(Product product);

  /**
   * This method converts a list of product entity to a list of product data dto.
   *
   * @param products the list of product entity object
   * @return list of product data dto
   */
  List<ProductDataDto> mapProductListToProductDataDtoList(List<Product> products);

  /**
   * This method converts product data dto to product entity.
   *
   * @param productDataDto the product data dto object
   * @return product entity object
   */
  Product mapProductDataDtoToProduct(ProductDataDto productDataDto);

}
