package com.openclassrooms.mddapi.user.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.mddapi.user.entity.UserDetailEntity;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetailEntity, UUID> {
  Optional<UserDetailEntity> findByEmail(String email);
  Optional<UserDetailEntity> findByUsername(String username);
  boolean existsByEmail(String email);
  boolean existsByUsername(String username);
}
