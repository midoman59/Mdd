package com.openclassrooms.mddapi.topic.controller;

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

import com.openclassrooms.mddapi.topic.dto.TopicDTO;
import com.openclassrooms.mddapi.topic.service.TopicService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/topics")
@AllArgsConstructor
public class TopicController {

  private final TopicService topicService;

  @GetMapping
  public ResponseEntity<List<TopicDTO>> getAllTopics() {
    List<TopicDTO> topics = topicService.getAllTopics();
    return ResponseEntity.ok(topics);
  }

  @GetMapping("/{id}")
  public ResponseEntity<TopicDTO> getTopicById(@PathVariable UUID id) {
    TopicDTO topic = topicService.getTopicById(id);
    return ResponseEntity.ok(topic);
  }

  @PostMapping
  public ResponseEntity<TopicDTO> createTopic(@RequestBody TopicDTO topicDTO) {
    TopicDTO createdTopic = topicService.createTopic(topicDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdTopic);
  }

  @PutMapping("/{id}")
  public ResponseEntity<TopicDTO> updateTopic(
      @PathVariable UUID id,
      @RequestBody TopicDTO topicDTO) {
    TopicDTO updatedTopic = topicService.updateTopic(id, topicDTO);
    return ResponseEntity.ok(updatedTopic);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteTopic(@PathVariable UUID id) {
    topicService.deleteTopic(id);
    return ResponseEntity.noContent().build();
  }
}
