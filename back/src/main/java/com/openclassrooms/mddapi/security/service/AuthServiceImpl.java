package com.openclassrooms.mddapi.security.service;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.openclassrooms.mddapi.exceptions.ApiException;
import com.openclassrooms.mddapi.security.dto.AuthResponseDTO;
import com.openclassrooms.mddapi.security.dto.LoginDTO;
import com.openclassrooms.mddapi.security.dto.RegisterDTO;
import com.openclassrooms.mddapi.security.utils.JwtUtil;
import com.openclassrooms.mddapi.user.entity.UserDetailEntity;
import com.openclassrooms.mddapi.user.repository.UserDetailRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthServiceImpl {

  private final UserDetailRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtUtil jwtUtil;

  public AuthResponseDTO register(RegisterDTO registerDTO) {
    if (userRepository.existsByEmail(registerDTO.getEmail())) {
      throw new ApiException(HttpStatus.BAD_REQUEST, "Email already exists");
    }
    if (userRepository.existsByUsername(registerDTO.getUsername())) {
      throw new ApiException(HttpStatus.BAD_REQUEST, "Username already exists");
    }

    UserDetailEntity user = new UserDetailEntity(
        registerDTO.getUsername(),
        registerDTO.getEmail(),
        passwordEncoder.encode(registerDTO.getPassword())
    );

    userRepository.save(user);
    String token = jwtUtil.generateToken(user.getEmail());
    return new AuthResponseDTO(token);
  }

  public AuthResponseDTO login(LoginDTO loginDTO) {
    UserDetailEntity user = userRepository.findByEmail(loginDTO.getEmailOrUsername())
        .orElseGet(() -> userRepository.findByUsername(loginDTO.getEmailOrUsername())
            .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "User not found")));

    if (!passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
      throw new ApiException(HttpStatus.UNAUTHORIZED, "Invalid password");
    }

    String token = jwtUtil.generateToken(user.getEmail());
    return new AuthResponseDTO(token);
  }
}
