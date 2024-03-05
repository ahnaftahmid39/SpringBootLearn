package com.ahnaf.firstime.product;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

  private final ProductRepository productRepository;

  ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  void saveProduct(Product product) {
    productRepository.save(product);
  }

  public List<Product> getProducts() {
    return productRepository.findAll();
  }

  public void updateProduct(String productId, Product oldProduct) {
    productRepository.findById(productId).ifPresent(updatedProduct -> {
      updatedProduct.setName(oldProduct.getName() != null ? oldProduct.getName() : updatedProduct.getName());
      updatedProduct.setDescription(oldProduct.getDescription() != null ? oldProduct.getDescription() : updatedProduct.getDescription());
      updatedProduct.setPrice(oldProduct.getPrice() != 0 ? oldProduct.getPrice() : updatedProduct.getPrice());
      productRepository.save(updatedProduct);
    });
  }

  public void deleteProduct(String productId) {
    productRepository.deleteById(productId);
  }

  public Optional<Product> getProductById(String productId) {
    return productRepository.findById(productId);
  }

}
