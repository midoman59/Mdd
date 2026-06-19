package com.openclassrooms.mddapi.article.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.openclassrooms.mddapi.article.dto.ArticleDTO;
import com.openclassrooms.mddapi.article.entity.ArticleEntity;
import com.openclassrooms.mddapi.article.mapper.ArticleMapper;
import com.openclassrooms.mddapi.article.repository.ArticleRepository;
import com.openclassrooms.mddapi.exceptions.ApiException;
import com.openclassrooms.mddapi.topic.repository.TopicRepository;
import com.openclassrooms.mddapi.user.repository.UserDetailRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ArticleServiceImpl implements ArticleService {

  private final ArticleRepository articleRepository;
  private final ArticleMapper articleMapper;
  private final UserDetailRepository userRepository;
  private final TopicRepository topicRepository;

  @Override
  public List<ArticleDTO> getAllArticles() {
    return articleRepository.findAll().stream()
        .map(articleMapper::toDTO)
        .collect(Collectors.toList());
  }

  @Override
  public ArticleDTO getArticleById(UUID id) {
    ArticleEntity article = articleRepository.findById(id)
        .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Article not found"));
    return articleMapper.toDTO(article);
  }

  @Override
  public ArticleDTO createArticle(ArticleDTO articleDTO) {
    var user = userRepository.findById(articleDTO.getAuthorId())
        .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Author not found"));
    var topic = topicRepository.findById(articleDTO.getTopicId())
        .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Topic not found"));

    ArticleEntity article = new ArticleEntity(
        articleDTO.getTitle(),
        articleDTO.getDescription(),
        topic,
        user
    );

    ArticleEntity savedArticle = articleRepository.save(article);
    return articleMapper.toDTO(savedArticle);
  }

  @Override
  public ArticleDTO updateArticle(UUID id, ArticleDTO articleDTO) {
    ArticleEntity article = articleRepository.findById(id)
        .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Article not found"));

    if (articleDTO.getTitle() != null) {
      article.setTitle(articleDTO.getTitle());
    }
    if (articleDTO.getDescription() != null) {
      article.setDescription(articleDTO.getDescription());
    }

    ArticleEntity updatedArticle = articleRepository.save(article);
    return articleMapper.toDTO(updatedArticle);
  }

  @Override
  public void deleteArticle(UUID id) {
    if (!articleRepository.existsById(id)) {
      throw new ApiException(HttpStatus.NOT_FOUND, "Article not found");
    }
    articleRepository.deleteById(id);
  }
}
