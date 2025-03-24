package com.santt4na.rapidinner.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santt4na.rapidinner.dto.typesaccountDto.UserDto;
import com.santt4na.rapidinner.dto.typesaccountDto.UserRequestDto;
import com.santt4na.rapidinner.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService service;

  @PostMapping
  public ResponseEntity<UserDto> createUser(
      @Valid @RequestBody UserRequestDto userRequest) {
    UserDto createdUser = service.createUser(userRequest);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
  }

  @GetMapping
  public ResponseEntity<List<UserDto>> AllUsers() {
    List<UserDto> users = service.findAllUsers();
    return ResponseEntity.ok(users);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<UserDto>> userById(@PathVariable Long id) {
    Optional<UserDto> finded = service.findById(id);
    return ResponseEntity.ok(finded);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Optional<UserDto>> updateUser(@PathVariable Long id, @RequestBody UserRequestDto entity) {
    Optional<UserDto> updatedUser = service.updateUser(id, entity);
    return ResponseEntity.ok(updatedUser);
  }

  @DeleteMapping("/{id}")
  public void deleteUser(@PathVariable Long id) {
    service.deleteUser(id);
  }
}