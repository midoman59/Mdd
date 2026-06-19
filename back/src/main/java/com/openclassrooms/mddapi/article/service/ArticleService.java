package com.openclassrooms.mddapi.article.service;

import java.util.List;
import java.util.UUID;

import com.openclassrooms.mddapi.article.dto.ArticleDTO;

public interface ArticleService {
  List<ArticleDTO> getAllArticles();
  ArticleDTO getArticleById(UUID id);
  ArticleDTO createArticle(ArticleDTO articleDTO);
  ArticleDTO updateArticle(UUID id, ArticleDTO articleDTO);
  void deleteArticle(UUID id);
}
