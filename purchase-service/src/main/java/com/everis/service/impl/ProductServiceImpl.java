package com.everis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.model.Product;
import com.everis.repository.IProductRepository;
import com.everis.repository.IRepository;
import com.everis.service.IProductService;

import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl extends CRUDServiceImpl<Product, String> implements IProductService {

  @Autowired
  private IProductRepository repository;

  @Override
  protected IRepository<Product, String> getRepository() {

  return repository;

  }

  @Override
  public Mono<Product> findByProductName(String productName) {
  
  return repository.findByProductName(productName);
  
  }

}
