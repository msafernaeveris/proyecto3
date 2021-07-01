package com.everis.topic.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.everis.model.Purchase;
import com.everis.service.IPurchaseService;
import com.fasterxml.jackson.databind.ObjectMapper;

import reactor.core.Disposable;
import reactor.core.publisher.Mono;

@Component
public class CreditConsumerConsumer {
  
  @Autowired
  private IPurchaseService purchaseService;
  
  ObjectMapper objectMapper = new ObjectMapper();
  
  @KafkaListener(topics = "created-purchase-topic", groupId = "credit-consumer-group")
  public Disposable retrieveCreatedPurchase(String data) throws Exception {
  
  Purchase purchase = objectMapper.readValue(data, Purchase.class);
  
  if (!purchase.getProduct().getProductName().equals("TARJETA DE CREDITO")) {
  
    return null;
      
  }
  
  return Mono.just(purchase)
    .log()
    .flatMap(purchaseService::update)
    .subscribe();
  
  }
  
}
