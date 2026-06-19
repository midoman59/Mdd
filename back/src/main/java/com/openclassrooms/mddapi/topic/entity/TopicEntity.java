package com.openclassrooms.mddapi.topic.entity;

import com.openclassrooms.mddapi.utils.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "topics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TopicEntity extends BaseEntity {

  @NotBlank(message = "Title is required")
  @Column(name = "title", unique = true, nullable = false)
  private String title;

  @NotBlank(message = "Description is required")
  @Column(name = "description", nullable = false, columnDefinition = "TEXT")
  private String description;
}
