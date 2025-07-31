package com.nagarro.productservice.dto;

/**
 * Error Response DTO record.
 *
 * @author yankitchauhan
 */
public record ErrorResponseDto(String message, String timestamp, String status) {
}