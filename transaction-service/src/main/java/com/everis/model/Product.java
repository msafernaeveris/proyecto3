package com.everis.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Product {
  
  @Id
  private String id;
  
  @Field(name = "productName")
  private String productName;
  
  @Field(name = "productType")
  private String productType;
  
  @Field(name = "condition")
  private Condition condition;
  
}
