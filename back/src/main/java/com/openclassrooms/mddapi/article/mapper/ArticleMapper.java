package com.openclassrooms.mddapi.article.mapper;

import org.mapstruct.Mapper;

import com.openclassrooms.mddapi.article.dto.ArticleDTO;
import com.openclassrooms.mddapi.article.entity.ArticleEntity;

@Mapper(componentModel = "spring")
public interface ArticleMapper {
  ArticleDTO toDTO(ArticleEntity entity);
  ArticleEntity toEntity(ArticleDTO dto);
}
