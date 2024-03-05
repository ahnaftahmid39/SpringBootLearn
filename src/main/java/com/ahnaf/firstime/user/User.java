package com.ahnaf.firstime.user;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import com.ahnaf.firstime.product.Product;

import lombok.Data;

@Data
@Document(collection = "users")
public class User {
  @MongoId
  private ObjectId id;

  @lombok.NonNull
  @Indexed(unique = true)
  private String username;

  @lombok.NonNull
  private String password;

  @DBRef(db = "products")
  private List<Product> products = new ArrayList<>();

}
