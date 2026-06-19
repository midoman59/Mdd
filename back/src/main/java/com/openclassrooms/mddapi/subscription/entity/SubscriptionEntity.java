package com.openclassrooms.mddapi.subscription.entity;

import com.openclassrooms.mddapi.topic.entity.TopicEntity;
import com.openclassrooms.mddapi.user.entity.UserDetailEntity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "subscriptions")
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

  public SubscriptionEntity() {}

  public SubscriptionEntity(SubscriptionId id, UserDetailEntity user, TopicEntity topic, Boolean isSubscribed) {
    this.id = id;
    this.user = user;
    this.topic = topic;
    this.isSubscribed = isSubscribed;
  }

  public SubscriptionId getId() { return id; }
  public void setId(SubscriptionId id) { this.id = id; }

  public UserDetailEntity getUser() { return user; }
  public void setUser(UserDetailEntity user) { this.user = user; }

  public TopicEntity getTopic() { return topic; }
  public void setTopic(TopicEntity topic) { this.topic = topic; }

  public Boolean getIsSubscribed() { return isSubscribed; }
  public void setIsSubscribed(Boolean isSubscribed) { this.isSubscribed = isSubscribed; }
}
