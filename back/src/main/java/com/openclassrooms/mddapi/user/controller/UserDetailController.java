package com.openclassrooms.mddapi.user.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

  @GetMapping("/{id}")
  public ResponseEntity<UserDetailDTO> getUserById(@PathVariable UUID id) {
    UserDetailDTO user = userDetailService.getUserById(id);
    return ResponseEntity.ok(user);
  }

  @PutMapping("/{id}")
  public ResponseEntity<UserDetailDTO> updateUser(
      @PathVariable UUID id,
      @RequestBody UserDetailDTO userDTO) {
    UserDetailDTO updatedUser = userDetailService.updateUser(id, userDTO);
    return ResponseEntity.ok(updatedUser);
  }
}
