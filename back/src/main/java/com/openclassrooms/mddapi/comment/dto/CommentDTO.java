package com.openclassrooms.mddapi.comment.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class CommentDTO {
  private UUID id;
  private String content;
  private UUID articleId;
  private UUID authorId;
  private LocalDateTime createdAt;

  public CommentDTO() {}

  public UUID getId() { return id; }
  public void setId(UUID id) { this.id = id; }

  public String getContent() { return content; }
  public void setContent(String content) { this.content = content; }

  public UUID getArticleId() { return articleId; }
  public void setArticleId(UUID articleId) { this.articleId = articleId; }

  public UUID getAuthorId() { return authorId; }
  public void setAuthorId(UUID authorId) { this.authorId = authorId; }

  public LocalDateTime getCreatedAt() { return createdAt; }
  public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
