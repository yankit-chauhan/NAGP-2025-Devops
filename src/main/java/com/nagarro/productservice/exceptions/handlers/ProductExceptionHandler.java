package com.nagarro.productservice.exceptions.handlers;

import com.nagarro.productservice.api.exceptions.ProductNotFoundException;
import com.nagarro.productservice.constants.ProductConstants;
import com.nagarro.productservice.dto.ErrorResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Custom exception handler to handle all exceptions across the microservice.
 *
 * @author yankitchauhan
 */
@ControllerAdvice
@Slf4j
public class ProductExceptionHandler {

  /**
   * This class handles Product not found exception.
   *
   * @param ex the exception
   * @return Response entity error object
   */
  @ExceptionHandler(ProductNotFoundException.class)
  public ResponseEntity<Object> handleProductNotFoundException(ProductNotFoundException ex) {
    log.warn(ex.getMessage());
    ErrorResponseDto errorResponseDto = new ErrorResponseDto(ex.getMessage(),
        getCurrentTimestamp(), HttpStatus.NOT_FOUND.name());
    return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
  }

  /**
   * This class handles MethodArgumentTypeMismatchException.
   *
   * @param ex the exception
   * @return Response entity error object
   */
  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  public ResponseEntity<Object> handleMethodArgumentTypeMismatchException(
      MethodArgumentTypeMismatchException ex) {
    log.warn(ex.getMessage());
    ErrorResponseDto errorResponseDto = new ErrorResponseDto(ex.getMessage(),
        getCurrentTimestamp(), HttpStatus.BAD_REQUEST.name());
    return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
  }

  /**
   * This class handles any uncaught exception.
   *
   * @param ex the exception
   * @return Response entity error object
   */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<Object> handleUncaughtException(Exception ex) {
    log.error(ex.getMessage());
    ErrorResponseDto errorResponseDto = new ErrorResponseDto(ex.getMessage(),
        getCurrentTimestamp(), HttpStatus.INTERNAL_SERVER_ERROR.name());
    return new ResponseEntity<>(errorResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  private String getCurrentTimestamp() {
    return LocalDateTime
        .now()
        .format(DateTimeFormatter.ofPattern(ProductConstants.ERROR_TIMESTAMP_FORMAT));
  }

}
