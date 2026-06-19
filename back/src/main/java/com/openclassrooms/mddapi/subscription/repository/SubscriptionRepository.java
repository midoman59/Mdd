package com.openclassrooms.mddapi.subscription.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.mddapi.subscription.entity.SubscriptionEntity;
import com.openclassrooms.mddapi.subscription.entity.SubscriptionId;

@Repository
public interface SubscriptionRepository extends JpaRepository<SubscriptionEntity, SubscriptionId> {
  List<SubscriptionEntity> findByUserId(UUID userId);
  Optional<SubscriptionEntity> findByUserIdAndTopicId(UUID userId, UUID topicId);
}
