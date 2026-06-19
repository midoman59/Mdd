package com.openclassrooms.mddapi.user.entity;

import com.openclassrooms.mddapi.utils.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class UserDetailEntity extends BaseEntity {

  @NotBlank(message = "Username is required")
  @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
  @Column(name = "username", unique = true, nullable = false)
  private String username;

  @NotBlank(message = "Email is required")
  @Email(message = "Email should be valid")
  @Column(name = "email", unique = true, nullable = false)
  private String email;

  @NotBlank(message = "Password is required")
  @Column(name = "password", nullable = false)
  private String password;

  public UserDetailEntity() {}

  public UserDetailEntity(String username, String email, String password) {
    this.username = username;
    this.email = email;
    this.password = password;
  }

  public String getUsername() { return username; }
  public void setUsername(String username) { this.username = username; }

  public String getEmail() { return email; }
  public void setEmail(String email) { this.email = email; }

  public String getPassword() { return password; }
  public void setPassword(String password) { this.password = password; }
}
