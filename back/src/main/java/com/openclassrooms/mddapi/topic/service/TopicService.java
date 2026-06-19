package com.openclassrooms.mddapi.topic.service;

import java.util.List;
import java.util.UUID;

import com.openclassrooms.mddapi.topic.dto.TopicDTO;

public interface TopicService {
  List<TopicDTO> getAllTopics();
  TopicDTO getTopicById(UUID id);
  TopicDTO createTopic(TopicDTO topicDTO);
  TopicDTO updateTopic(UUID id, TopicDTO topicDTO);
  void deleteTopic(UUID id);
}
