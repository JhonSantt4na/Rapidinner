package com.santt4na.rapidinner.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santt4na.rapidinner.dto.accountTypesDto.UserDto;
import com.santt4na.rapidinner.dto.accountTypesDto.UserRequestDto;
import com.santt4na.rapidinner.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping
  public ResponseEntity<UserDto> createUser(
      @Valid @RequestBody UserRequestDto userRequest) {
    UserDto createdUser = userService.createUser(userRequest);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
  }

  @GetMapping
  public ResponseEntity<List<UserDto>> getAllUsers() {
    List<UserDto> users = userService.findAllUsers();
    return ResponseEntity.ok(users);
  }
}