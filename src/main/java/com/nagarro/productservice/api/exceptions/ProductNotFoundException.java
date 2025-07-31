package com.nagarro.productservice.api.exceptions;

/**
 * Custom class to handle product not found error.
 *
 * @author yankitchauhan
 */
public class ProductNotFoundException extends RuntimeException {

  public ProductNotFoundException(String message) {
    super(message);
  }

}
