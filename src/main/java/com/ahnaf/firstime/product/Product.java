package com.ahnaf.firstime.product;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
  @MongoId
  private String id;
  @NonNull
  private String name;
  @NonNull
  private String description;
  @NonNull
  private Double price;

}
