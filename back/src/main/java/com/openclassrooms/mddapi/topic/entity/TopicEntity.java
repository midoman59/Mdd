package com.openclassrooms.mddapi.topic.entity;

import com.openclassrooms.mddapi.utils.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "topics")
public class TopicEntity extends BaseEntity {

  @NotBlank(message = "Title is required")
  @Column(name = "title", unique = true, nullable = false)
  private String title;

  @NotBlank(message = "Description is required")
  @Column(name = "description", nullable = false, columnDefinition = "TEXT")
  private String description;

  public TopicEntity() {}

  public TopicEntity(String title, String description) {
    this.title = title;
    this.description = description;
  }

  public String getTitle() { return title; }
  public void setTitle(String title) { this.title = title; }

  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }
}
