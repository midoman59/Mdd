package com.openclassrooms.mddapi.comment.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.mddapi.comment.dto.CommentDTO;
import com.openclassrooms.mddapi.comment.service.CommentServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/comments")
@AllArgsConstructor
public class CommentController {

  private final CommentServiceImpl commentService;

  @GetMapping
  public ResponseEntity<List<CommentDTO>> getCommentsByArticleId(@RequestParam UUID articleId) {
    List<CommentDTO> comments = commentService.getCommentsByArticleId(articleId);
    return ResponseEntity.ok(comments);
  }

  @PostMapping
  public ResponseEntity<CommentDTO> createComment(@RequestBody CommentDTO commentDTO) {
    CommentDTO createdComment = commentService.createComment(commentDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdComment);
  }
}
