package com.openclassrooms.mddapi.topic.mapper;

import org.mapstruct.Mapper;

import com.openclassrooms.mddapi.topic.dto.TopicDTO;
import com.openclassrooms.mddapi.topic.entity.TopicEntity;

@Mapper(componentModel = "spring")
public interface TopicMapper {
  TopicDTO toDTO(TopicEntity entity);
  TopicEntity toEntity(TopicDTO dto);
}
