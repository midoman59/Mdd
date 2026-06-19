package com.openclassrooms.mddapi.user.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.mddapi.user.dto.UserDetailDTO;
import com.openclassrooms.mddapi.user.service.UserDetailService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserDetailController {

  private final UserDetailService userDetailService;

  @GetMapping("/me")
  public ResponseEntity<UserDetailDTO> getCurrentUser(Authentication authentication) {
    String email = authentication.getName();
    UserDetailDTO user = userDetailService.getUserByEmail(email);
    return ResponseEntity.ok(user);
  }

  @PutMapping("/me")
  public ResponseEntity<UserDetailDTO> updateCurrentUser(
      Authentication authentication,
      @RequestBody UserDetailDTO userDTO) {
    String email = authentication.getName();
    UserDetailDTO currentUser = userDetailService.getUserByEmail(email);
    UserDetailDTO updatedUser = userDetailService.updateUser(currentUser.getId(), userDTO);
    return ResponseEntity.ok(updatedUser);
  }
}
