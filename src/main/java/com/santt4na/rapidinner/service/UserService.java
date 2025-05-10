package com.santt4na.rapidinner.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.santt4na.rapidinner.dto.typesaccountDto.UserDto;
import com.santt4na.rapidinner.dto.typesaccountDto.UserRequestDto;
import com.santt4na.rapidinner.enums.UserType;
import com.santt4na.rapidinner.mapper.MapperUser;
import com.santt4na.rapidinner.model.delivery.AddressApp;
import com.santt4na.rapidinner.model.typesaccount.Admin;
import com.santt4na.rapidinner.model.typesaccount.Customer;
import com.santt4na.rapidinner.model.typesaccount.DeliveryMan;
import com.santt4na.rapidinner.model.typesaccount.Merchant;
import com.santt4na.rapidinner.model.typesaccount.User;
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

  public Optional<UserDto> findById(Long id) {
    return userRepository.findById(id)
        .map(mapperUser::toDto);
  }

  public Optional<UserDto> updateUser(Long id, UserRequestDto userRequest) {
    return userRepository.findById(id)
        .map(existingUser -> {
          if (userRequest.role() != existingUser.getRole()) {
            throw new IllegalArgumentException("Não é possível alterar o tipo de usuário");
          }

          existingUser.setName(userRequest.name());
          existingUser.setEmail(userRequest.email());

          switch (existingUser.getRole()) {
            case ROLE_ADMIN -> {
              Admin admin = (Admin) existingUser;
              if (userRequest.active() != null) {
                admin.setActive(userRequest.active());
              }
              admin.setLastLogin(LocalDateTime.now().toString());
            }
            case ROLE_DELIVERYMAN -> {
              DeliveryMan deliveryMan = (DeliveryMan) existingUser;
              if (userRequest.rating() != null) {
                deliveryMan.setRating(userRequest.rating());
              }
              if (userRequest.cnh() != null) {
                deliveryMan.setCnh(userRequest.cnh());
              }
              if (userRequest.available() != null) {
                deliveryMan.setAvailable(userRequest.available());
              }
              if (userRequest.vehicle() != null) {
                deliveryMan.setVehicle(mapperUser.vehicleDtoToVehicle(userRequest.vehicle()));
              }
            }
            case ROLE_MERCHANT -> {
              Merchant merchant = (Merchant) existingUser;
              if (userRequest.cnpj() != null) {
                merchant.setCnpj(userRequest.cnpj());
              }
              if (userRequest.companyName() != null) {
                merchant.setCompanyName(userRequest.companyName());
              }
              if (userRequest.businessAddress() != null) {
                merchant.setBusinessAddress(userRequest.businessAddress());
              }
            }
            case ROLE_CUSTOMER -> {
              Customer customer = (Customer) existingUser;
              if (userRequest.cpf() != null) {
                customer.setCpf(userRequest.cpf());
              }
              if (userRequest.addresses() != null) {
                if (userRequest.addresses().isEmpty()) {
                  throw new IllegalArgumentException("Pelo menos um endereço é obrigatório para Customer");
                }
                customer.getAddresses().clear();
                userRequest.addresses().forEach((type, addressDto) -> {
                  AddressApp address = mapperUser.addressDtoToAddress(addressDto);
                  customer.addAddress(type, address);
                });
              }
            }
          }

          User updatedUser = userRepository.save(existingUser);
          log.info("Usuário atualizado ID: {}", id);
          return mapperUser.toDto(updatedUser);
        });
  }

  public boolean deleteUser(Long id) {
    return userRepository.findById(id)
        .map(user -> {
          userRepository.delete(user);
          log.info("Usuário deletado ID: {}", id);
          return true;
        })
        .orElse(false);
  }

}