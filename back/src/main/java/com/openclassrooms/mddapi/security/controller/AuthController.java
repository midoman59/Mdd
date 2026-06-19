package com.openclassrooms.mddapi.security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.mddapi.security.dto.AuthResponseDTO;
import com.openclassrooms.mddapi.security.dto.LoginDTO;
import com.openclassrooms.mddapi.security.dto.RegisterDTO;
import com.openclassrooms.mddapi.security.service.AuthServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

  private final AuthServiceImpl authService;

  @PostMapping("/register")
  public ResponseEntity<AuthResponseDTO> register(@RequestBody RegisterDTO registerDTO) {
    AuthResponseDTO response = authService.register(registerDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  @PostMapping("/login")
  public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDTO loginDTO) {
    AuthResponseDTO response = authService.login(loginDTO);
    return ResponseEntity.ok(response);
  }
}
