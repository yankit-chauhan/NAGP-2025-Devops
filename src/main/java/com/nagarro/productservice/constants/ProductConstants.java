package com.nagarro.productservice.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductConstants {

  public static final String ERROR_TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss";
  public static final String PRODUCT_NOT_FOUND_MESSAGE = "No product found for the provided id: %s";

}
