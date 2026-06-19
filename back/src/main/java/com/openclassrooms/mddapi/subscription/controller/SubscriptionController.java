package com.openclassrooms.mddapi.subscription.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.mddapi.subscription.service.SubscriptionService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/subscriptions")
@AllArgsConstructor
public class SubscriptionController {

  private final SubscriptionService subscriptionService;

  @PostMapping
  public ResponseEntity<Void> subscribe(
      @RequestParam UUID userId,
      @RequestParam UUID topicId) {
    subscriptionService.subscribe(userId, topicId);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @DeleteMapping
  public ResponseEntity<Void> unsubscribe(
      @RequestParam UUID userId,
      @RequestParam UUID topicId) {
    subscriptionService.unsubscribe(userId, topicId);
    return ResponseEntity.noContent().build();
  }
}
