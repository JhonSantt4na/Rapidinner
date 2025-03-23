package com.santt4na.rapidinner.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.santt4na.rapidinner.dto.accountTypesDto.UserDto;
import com.santt4na.rapidinner.dto.accountTypesDto.UserRequestDto;
import com.santt4na.rapidinner.enums.UserType;
import com.santt4na.rapidinner.mapper.MapperUser;
import com.santt4na.rapidinner.model.accountTypes.Admin;
import com.santt4na.rapidinner.model.accountTypes.Customer;
import com.santt4na.rapidinner.model.accountTypes.DeliveryMan;
import com.santt4na.rapidinner.model.accountTypes.Merchant;
import com.santt4na.rapidinner.model.accountTypes.User;
import com.santt4na.rapidinner.model.delivery.AddressApp;
import com.santt4na.rapidinner.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final MapperUser mapperUser;

  public UserDto createUser(UserRequestDto userRequest) {
    if (userRequest.role() == null) {
      throw new IllegalArgumentException("Role selection is required");
    }

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

      case ROLE_MERCHANT -> new Merchant(
          userRequest.name(),
          userRequest.email(),
          userRequest.role(),
          userRequest.cnpj(),
          userRequest.companyName(),
          userRequest.businessAddress());

      case ROLE_CUSTOMER -> {
        Customer customer = new Customer(
            userRequest.name(),
            userRequest.email(),
            userRequest.role(),
            userRequest.cpf());

        // Valida e adiciona endereços
        if (userRequest.addresses() != null && !userRequest.addresses().isEmpty()) {
          userRequest.addresses().forEach((type, addressDto) -> {
            AddressApp address = mapperUser.addressDtoToAddress(addressDto);
            customer.addAddress(type, address);
          });
        } else if (userRequest.role() == UserType.ROLE_CUSTOMER) {
          throw new IllegalArgumentException("Pelo menos um endereço é obrigatório para Customer");
        }

        yield customer;
      }
      default -> throw new IllegalArgumentException("Role inválida: " + userRequest.role());
    };

    User savedUser = userRepository.save(newUser);
    log.info("User Created " + userRequest.role().getValue());
    return mapperUser.toDto(savedUser);
  }

  public List<UserDto> findAllUsers() {
    List<User> users = userRepository.findAll();
    log.info("Listed All Users");
    return users.stream()
        .map(mapperUser::toDto)
        .toList();

  }
}