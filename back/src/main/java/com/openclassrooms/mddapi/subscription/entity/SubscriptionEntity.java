package com.openclassrooms.mddapi.subscription.entity;

import java.io.Serializable;
import java.util.UUID;

import com.openclassrooms.mddapi.topic.entity.TopicEntity;
import com.openclassrooms.mddapi.user.entity.UserDetailEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
class SubscriptionId implements Serializable {
  private UUID userId;
  private UUID topicId;
}

@Entity
@Table(name = "subscriptions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubscriptionEntity {

  @EmbeddedId
  private SubscriptionId id;

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("userId")
  @JoinColumn(name = "user_id")
  private UserDetailEntity user;

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("topicId")
  @JoinColumn(name = "topic_id")
  private TopicEntity topic;

  @Column(name = "is_subscribed", nullable = false)
  private Boolean isSubscribed;
}
