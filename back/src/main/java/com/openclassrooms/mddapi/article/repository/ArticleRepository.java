package com.openclassrooms.mddapi.article.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.mddapi.article.entity.ArticleEntity;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, UUID> {
  List<ArticleEntity> findByAuthorId(UUID authorId);
  List<ArticleEntity> findByTopicId(UUID topicId);
}
