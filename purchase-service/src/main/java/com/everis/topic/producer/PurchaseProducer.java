package com.everis.topic.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.everis.model.Purchase;

@Component
public class PurchaseProducer {
  
  @Autowired
  private KafkaTemplate<String, Object> kafkaTemplate;  

  private String createdPurchaseTopic = "created-purchase-topic";
  
  public void sendCreatePurchase(Purchase purchase) {
  
  kafkaTemplate.send(createdPurchaseTopic, purchase);
  
  }
  
}
