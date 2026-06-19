package com.openclassrooms.mddapi.subscription.service;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.openclassrooms.mddapi.exceptions.ApiException;
import com.openclassrooms.mddapi.subscription.entity.SubscriptionEntity;
import com.openclassrooms.mddapi.subscription.entity.SubscriptionId;
import com.openclassrooms.mddapi.subscription.repository.SubscriptionRepository;
import com.openclassrooms.mddapi.topic.repository.TopicRepository;
import com.openclassrooms.mddapi.user.repository.UserDetailRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

  private final SubscriptionRepository subscriptionRepository;
  private final UserDetailRepository userRepository;
  private final TopicRepository topicRepository;

  @Override
  public void subscribe(UUID userId, UUID topicId) {
    var user = userRepository.findById(userId)
        .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "User not found"));
    var topic = topicRepository.findById(topicId)
        .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Topic not found"));

    SubscriptionEntity subscription = new SubscriptionEntity(
        new SubscriptionId(userId, topicId),
        user,
        topic,
        true
    );

    subscriptionRepository.save(subscription);
  }

  @Override
  public void unsubscribe(UUID userId, UUID topicId) {
    SubscriptionEntity subscription = subscriptionRepository.findByUserIdAndTopicId(userId, topicId)
        .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Subscription not found"));
    subscriptionRepository.delete(subscription);
  }

  @Override
  public boolean isSubscribed(UUID userId, UUID topicId) {
    return subscriptionRepository.findByUserIdAndTopicId(userId, topicId)
        .map(SubscriptionEntity::getIsSubscribed)
        .orElse(false);
  }
}
