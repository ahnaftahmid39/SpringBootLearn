package com.ahnaf.firstime.product;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping(value = { "", "/" })
  public List<Product> getProducts() {
    return productService.getProducts();
  }

  @GetMapping(value = "/{productId}")
  public ResponseEntity<Product> getProductById(@PathVariable("productId") String productId) {
    Optional<Product> product = productService.getProductById(productId);

    if (product.isPresent()) {
      return ResponseEntity.ok().body(product.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping(value = { "", "/" })
  public void addProduct(@RequestBody Product product) {
    productService.saveProduct(product);
  }

  @DeleteMapping(value = "/{productId}")
  public void deleteProduct(@PathVariable("productId") String productId) {
    productService.deleteProduct(productId);
  }

  @PutMapping(value = "/{productId}")
  public void updateProduct(
      @PathVariable("productId") String productId,
      @RequestBody Product product) {
    productService.updateProduct(productId, product);
  }
}
