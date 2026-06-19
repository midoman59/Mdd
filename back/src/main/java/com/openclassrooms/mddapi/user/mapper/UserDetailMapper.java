package com.openclassrooms.mddapi.user.mapper;

import org.mapstruct.Mapper;

import com.openclassrooms.mddapi.user.dto.UserDetailDTO;
import com.openclassrooms.mddapi.user.entity.UserDetailEntity;

@Mapper(componentModel = "spring")
public interface UserDetailMapper {
  UserDetailDTO toDTO(UserDetailEntity entity);
  UserDetailEntity toEntity(UserDetailDTO dto);
}
