package com.openclassrooms.mddapi.article.entity;

import java.util.List;

import com.openclassrooms.mddapi.topic.entity.TopicEntity;
import com.openclassrooms.mddapi.user.entity.UserDetailEntity;
import com.openclassrooms.mddapi.utils.entity.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "articles")
public class ArticleEntity extends BaseEntity {

  @NotBlank(message = "Title is required")
  @Column(name = "title", nullable = false)
  private String title;

  @NotBlank(message = "Description is required")
  @Column(name = "description", nullable = false, columnDefinition = "TEXT")
  private String description;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "topic_id", nullable = false)
  private TopicEntity topic;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private UserDetailEntity author;

  @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<ArticleEntity> comments;

  public ArticleEntity() {}

  public ArticleEntity(String title, String description, TopicEntity topic, UserDetailEntity author) {
    this.title = title;
    this.description = description;
    this.topic = topic;
    this.author = author;
  }

  public String getTitle() { return title; }
  public void setTitle(String title) { this.title = title; }

  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }

  public TopicEntity getTopic() { return topic; }
  public void setTopic(TopicEntity topic) { this.topic = topic; }

  public UserDetailEntity getAuthor() { return author; }
  public void setAuthor(UserDetailEntity author) { this.author = author; }

  public List<ArticleEntity> getComments() { return comments; }
  public void setComments(List<ArticleEntity> comments) { this.comments = comments; }
}
