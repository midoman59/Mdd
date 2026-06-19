package com.openclassrooms.mddapi.topic.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.openclassrooms.mddapi.exceptions.ApiException;
import com.openclassrooms.mddapi.topic.dto.TopicDTO;
import com.openclassrooms.mddapi.topic.entity.TopicEntity;
import com.openclassrooms.mddapi.topic.mapper.TopicMapper;
import com.openclassrooms.mddapi.topic.repository.TopicRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TopicServiceImpl implements TopicService {

  private final TopicRepository topicRepository;
  private final TopicMapper topicMapper;

  @Override
  public List<TopicDTO> getAllTopics() {
    return topicRepository.findAll().stream()
        .map(topicMapper::toDTO)
        .collect(Collectors.toList());
  }

  @Override
  public TopicDTO getTopicById(UUID id) {
    TopicEntity topic = topicRepository.findById(id)
        .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Topic not found"));
    return topicMapper.toDTO(topic);
  }

  @Override
  public TopicDTO createTopic(TopicDTO topicDTO) {
    TopicEntity topic = topicMapper.toEntity(topicDTO);
    TopicEntity savedTopic = topicRepository.save(topic);
    return topicMapper.toDTO(savedTopic);
  }

  @Override
  public TopicDTO updateTopic(UUID id, TopicDTO topicDTO) {
    TopicEntity topic = topicRepository.findById(id)
        .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Topic not found"));

    if (topicDTO.getTitle() != null) {
      topic.setTitle(topicDTO.getTitle());
    }
    if (topicDTO.getDescription() != null) {
      topic.setDescription(topicDTO.getDescription());
    }

    TopicEntity updatedTopic = topicRepository.save(topic);
    return topicMapper.toDTO(updatedTopic);
  }

  @Override
  public void deleteTopic(UUID id) {
    if (!topicRepository.existsById(id)) {
      throw new ApiException(HttpStatus.NOT_FOUND, "Topic not found");
    }
    topicRepository.deleteById(id);
  }
}
