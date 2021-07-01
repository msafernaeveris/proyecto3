package com.everis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.model.Purchase;
import com.everis.repository.IPurchaseRepository;
import com.everis.repository.IRepository;
import com.everis.service.IPurchaseService;

import reactor.core.publisher.Mono;

@Service
public class PurchaseService extends CRUDServiceImpl<Purchase, String> implements IPurchaseService {

  @Autowired
  private IPurchaseRepository repository;
  
  @Override
  protected IRepository<Purchase, String> getRepository() {
  
  return repository;
  
  }

  @Override
  public Mono<Purchase> findByCardNumber(String cardNumber) {
  
  return repository.findByCardNumber(cardNumber);
  
  }
  
}
