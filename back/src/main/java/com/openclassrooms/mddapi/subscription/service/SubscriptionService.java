package com.openclassrooms.mddapi.subscription.service;

import java.util.UUID;

public interface SubscriptionService {
  void subscribe(UUID userId, UUID topicId);
  void unsubscribe(UUID userId, UUID topicId);
  boolean isSubscribed(UUID userId, UUID topicId);
}
