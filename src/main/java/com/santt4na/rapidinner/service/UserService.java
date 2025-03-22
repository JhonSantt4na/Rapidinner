package com.santt4na.rapidinner.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.santt4na.rapidinner.dto.accountTypesDto.UserDto;
import com.santt4na.rapidinner.dto.accountTypesDto.UserRequestDto;
import com.santt4na.rapidinner.mapper.MapperUser;
import com.santt4na.rapidinner.model.accountTypes.Admin;
import com.santt4na.rapidinner.model.accountTypes.DeliveryMan;
import com.santt4na.rapidinner.model.accountTypes.User;
import com.santt4na.rapidinner.repository.UserRepository;

import lombok.RequiredArgsConstructor;

/*@RequiredArgsConstructor
public class UserService {

private final UserRepository userRepository;
  private final MapperUser mapperUser;

  public UserDto createUser(UserRequestDto userRequest) {
    if (userRequest.role() == null) {
      throw new IllegalArgumentException("Role é obrigatória");
    }

    User newUser = switch (userRequest.role()) {
      case ROLE_ADMIN -> createAdmin(userRequest);
      case ROLE_DELIVERYMAN -> createDeliveryMan(userRequest);
      default -> throw new IllegalArgumentException("Role inválida: " + userRequest.role());
    };

    User savedUser = userRepository.save(newUser);
    return mapperUser.toDto(savedUser);
  }

  private Admin createAdmin(UserRequestDto dto) {
    return new Admin(
        dto.name(),
        dto.email(),
        dto.role(),
        dto.active() != null ? dto.active() : true,
        dto.lastLogin() != null ? dto.lastLogin() : LocalDateTime.now().toString());
  }

  private DeliveryMan createDeliveryMan(UserRequestDto dto) {
    return new DeliveryMan(
        dto.name(),
        dto.email(),
        dto.role(),
        dto.rating(),
        dto.cnh(),
        dto.available() != null ? dto.available() : true,
        convertVehicleDtoToEntity(dto.vehicle()));
  }

  private Vehicle convertVehicleDtoToEntity(VehicleDto dto) {
    return new Vehicle(
        dto.vehicleType(),
        dto.color(),
        dto.model(),
        dto.plate());
  }
}
*/

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final MapperUser mapperUser;

  public UserDto createUser(UserRequestDto userRequest) {
    User newUser = switch (userRequest.role()) {
      case ROLE_ADMIN -> new Admin(
          userRequest.name(),
          userRequest.email(),
          userRequest.role(),
          userRequest.active() != null ? userRequest.active() : true,
          LocalDateTime.now().toString());

      case ROLE_DELIVERYMAN -> new DeliveryMan(
          userRequest.name(),
          userRequest.email(),
          userRequest.role(),
          userRequest.rating(),
          userRequest.cnh(),
          userRequest.available() != null ? userRequest.available() : true,
          mapperUser.vehicleDtoToVehicle(userRequest.vehicle()));

      default -> throw new IllegalArgumentException("Role inválida: " + userRequest.role());
    };

    User savedUser = userRepository.save(newUser);
    return mapperUser.toDto(savedUser);
  }

  public List<UserDto> findAllUsers() {
    List<User> users = userRepository.findAll();
    return users.stream()
        .map(mapperUser::toDto)
        .toList();
  }
}