package com.openclassrooms.mddapi.article.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class ArticleDTO {
  private UUID id;
  private String title;
  private String description;
  private UUID topicId;
  private UUID authorId;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  public ArticleDTO() {}

  public UUID getId() { return id; }
  public void setId(UUID id) { this.id = id; }

  public String getTitle() { return title; }
  public void setTitle(String title) { this.title = title; }

  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }

  public UUID getTopicId() { return topicId; }
  public void setTopicId(UUID topicId) { this.topicId = topicId; }

  public UUID getAuthorId() { return authorId; }
  public void setAuthorId(UUID authorId) { this.authorId = authorId; }

  public LocalDateTime getCreatedAt() { return createdAt; }
  public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

  public LocalDateTime getUpdatedAt() { return updatedAt; }
  public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
