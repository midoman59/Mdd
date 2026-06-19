package com.openclassrooms.mddapi.user.service;

import java.util.UUID;

import com.openclassrooms.mddapi.user.dto.UserDetailDTO;

public interface UserDetailService {
  UserDetailDTO getUserById(UUID id);
  UserDetailDTO getUserByEmail(String email);
  UserDetailDTO updateUser(UUID id, UserDetailDTO userDTO);
}
