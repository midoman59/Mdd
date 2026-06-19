package com.openclassrooms.mddapi.comment.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.openclassrooms.mddapi.article.repository.ArticleRepository;
import com.openclassrooms.mddapi.comment.dto.CommentDTO;
import com.openclassrooms.mddapi.comment.entity.CommentEntity;
import com.openclassrooms.mddapi.comment.mapper.CommentMapper;
import com.openclassrooms.mddapi.comment.repository.CommentRepository;
import com.openclassrooms.mddapi.exceptions.ApiException;
import com.openclassrooms.mddapi.user.repository.UserDetailRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CommentServiceImpl {

  private final CommentRepository commentRepository;
  private final CommentMapper commentMapper;
  private final ArticleRepository articleRepository;
  private final UserDetailRepository userRepository;

  public List<CommentDTO> getCommentsByArticleId(UUID articleId) {
    return commentRepository.findByArticleId(articleId).stream()
        .map(commentMapper::toDTO)
        .collect(Collectors.toList());
  }

  public CommentDTO createComment(CommentDTO commentDTO) {
    var article = articleRepository.findById(commentDTO.getArticleId())
        .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Article not found"));
    var author = userRepository.findById(commentDTO.getAuthorId())
        .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Author not found"));

    CommentEntity comment = new CommentEntity(
        commentDTO.getContent(),
        article,
        author
    );

    CommentEntity savedComment = commentRepository.save(comment);
    return commentMapper.toDTO(savedComment);
  }
}
