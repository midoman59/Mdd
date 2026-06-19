package com.openclassrooms.mddapi.comment.mapper;

import org.mapstruct.Mapper;

import com.openclassrooms.mddapi.comment.dto.CommentDTO;
import com.openclassrooms.mddapi.comment.entity.CommentEntity;

@Mapper(componentModel = "spring")
public interface CommentMapper {
  CommentDTO toDTO(CommentEntity entity);
  CommentEntity toEntity(CommentDTO dto);
}
