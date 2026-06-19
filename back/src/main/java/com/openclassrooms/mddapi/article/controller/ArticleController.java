package com.openclassrooms.mddapi.article.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.mddapi.article.dto.ArticleDTO;
import com.openclassrooms.mddapi.article.service.ArticleService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/articles")
@AllArgsConstructor
public class ArticleController {

  private final ArticleService articleService;

  @GetMapping
  public ResponseEntity<List<ArticleDTO>> getAllArticles() {
    List<ArticleDTO> articles = articleService.getAllArticles();
    return ResponseEntity.ok(articles);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ArticleDTO> getArticleById(@PathVariable UUID id) {
    ArticleDTO article = articleService.getArticleById(id);
    return ResponseEntity.ok(article);
  }

  @PostMapping
  public ResponseEntity<ArticleDTO> createArticle(@RequestBody ArticleDTO articleDTO) {
    ArticleDTO createdArticle = articleService.createArticle(articleDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdArticle);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ArticleDTO> updateArticle(
      @PathVariable UUID id,
      @RequestBody ArticleDTO articleDTO) {
    ArticleDTO updatedArticle = articleService.updateArticle(id, articleDTO);
    return ResponseEntity.ok(updatedArticle);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteArticle(@PathVariable UUID id) {
    articleService.deleteArticle(id);
    return ResponseEntity.noContent().build();
  }
}
