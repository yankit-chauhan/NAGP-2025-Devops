package com.nagarro.productservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Product Service Tier Main Class.
 *
 * @author yankitchauhan
 */
@SpringBootApplication
@EnableWebMvc
@Slf4j
public class ProductServiceApplication {

  public static void main(String[] args) {
    ConfigurableApplicationContext ctx = SpringApplication.run(ProductServiceApplication.class, args);
    log.info("MY SQL URL: " + ctx.getEnvironment().getProperty("spring.datasource.url"));
  }

}
