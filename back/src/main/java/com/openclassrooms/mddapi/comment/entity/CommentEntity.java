package com.openclassrooms.mddapi.comment.entity;

import com.openclassrooms.mddapi.article.entity.ArticleEntity;
import com.openclassrooms.mddapi.user.entity.UserDetailEntity;
import com.openclassrooms.mddapi.utils.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "comments")
public class CommentEntity extends BaseEntity {

  @NotBlank(message = "Content is required")
  @Size(max = 500, message = "Comment cannot exceed 500 characters")
  @Column(name = "content", nullable = false, columnDefinition = "TEXT")
  private String content;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "article_id", nullable = false)
  private ArticleEntity article;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private UserDetailEntity author;

  public CommentEntity() {}

  public CommentEntity(String content, ArticleEntity article, UserDetailEntity author) {
    this.content = content;
    this.article = article;
    this.author = author;
  }

  public String getContent() { return content; }
  public void setContent(String content) { this.content = content; }

  public ArticleEntity getArticle() { return article; }
  public void setArticle(ArticleEntity article) { this.article = article; }

  public UserDetailEntity getAuthor() { return author; }
  public void setAuthor(UserDetailEntity author) { this.author = author; }
}
