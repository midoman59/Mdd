package com.openclassrooms.mddapi.subscription.entity;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Embeddable;

@Embeddable
public class SubscriptionId implements Serializable {
  private UUID userId;
  private UUID topicId;

  public SubscriptionId() {}

  public SubscriptionId(UUID userId, UUID topicId) {
    this.userId = userId;
    this.topicId = topicId;
  }

  public UUID getUserId() { return userId; }
  public void setUserId(UUID userId) { this.userId = userId; }

  public UUID getTopicId() { return topicId; }
  public void setTopicId(UUID topicId) { this.topicId = topicId; }
}
