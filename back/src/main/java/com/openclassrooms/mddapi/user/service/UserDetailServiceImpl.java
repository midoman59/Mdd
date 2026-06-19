package com.openclassrooms.mddapi.user.service;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.openclassrooms.mddapi.exceptions.ApiException;
import com.openclassrooms.mddapi.user.dto.UserDetailDTO;
import com.openclassrooms.mddapi.user.entity.UserDetailEntity;
import com.openclassrooms.mddapi.user.mapper.UserDetailMapper;
import com.openclassrooms.mddapi.user.repository.UserDetailRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailService {

  private final UserDetailRepository userDetailRepository;
  private final UserDetailMapper userDetailMapper;

  @Override
  public UserDetailDTO getUserById(UUID id) {
    UserDetailEntity user = userDetailRepository.findById(id)
        .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "User not found"));
    return userDetailMapper.toDTO(user);
  }

  @Override
  public UserDetailDTO getUserByEmail(String email) {
    UserDetailEntity user = userDetailRepository.findByEmail(email)
        .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "User not found"));
    return userDetailMapper.toDTO(user);
  }

  @Override
  public UserDetailDTO updateUser(UUID id, UserDetailDTO userDTO) {
    UserDetailEntity user = userDetailRepository.findById(id)
        .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "User not found"));

    if (userDTO.getUsername() != null) {
      user.setUsername(userDTO.getUsername());
    }
    if (userDTO.getEmail() != null) {
      user.setEmail(userDTO.getEmail());
    }

    UserDetailEntity updatedUser = userDetailRepository.save(user);
    return userDetailMapper.toDTO(updatedUser);
  }
}
