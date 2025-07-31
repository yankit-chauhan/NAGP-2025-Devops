package com.nagarro.productservice.dto;

import java.math.BigDecimal;

/**
 * Product DTO record.
 *
 * @author yankitchauhan
 */
public record ProductDataDto(Long id, String name, String description, String summary, String brand,
                             BigDecimal price, BigDecimal tax) {
}