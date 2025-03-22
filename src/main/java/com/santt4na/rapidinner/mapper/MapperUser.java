package com.santt4na.rapidinner.mapper;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.santt4na.rapidinner.dto.accountTypesDto.AdminDto;
import com.santt4na.rapidinner.dto.accountTypesDto.DeliveryManDto;
import com.santt4na.rapidinner.dto.accountTypesDto.UserDto;
import com.santt4na.rapidinner.dto.deliveryDto.VehicleDto;
import com.santt4na.rapidinner.model.accountTypes.Admin;
import com.santt4na.rapidinner.model.accountTypes.DeliveryMan;
import com.santt4na.rapidinner.model.accountTypes.User;
import com.santt4na.rapidinner.model.delivery.Vehicle;

@Mapper(componentModel = "spring")
public interface MapperUser {

    // Método principal para converter User em UserDto
    default UserDto toDto(User user) {
        if (user instanceof Admin) {
            return adminToAdminDto((Admin) user);
        } else if (user instanceof DeliveryMan) {
            return deliveryManToDeliveryManDto((DeliveryMan) user);
        }
        throw new IllegalArgumentException("Tipo de usuário não suportado: " + user.getClass());
    }

    // Método principal para converter UserDto em User
    default User toEntity(UserDto userDto) {
        if (userDto instanceof AdminDto) {
            return adminDtoToAdmin((AdminDto) userDto);
        } else if (userDto instanceof DeliveryManDto) {
            return deliveryManDtoToDeliveryMan((DeliveryManDto) userDto);
        }
        throw new IllegalArgumentException("Tipo de DTO não suportado: " + userDto.getClass());
    }

    // Mapeamento de Admin para AdminDto
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "updatedAt", source = "updatedAt")
    @Mapping(target = "active", source = "active")
    @Mapping(target = "lastLogin", source = "lastLogin")
    AdminDto adminToAdminDto(Admin admin);

    // Mapeamento de DeliveryMan para DeliveryManDto
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "updatedAt", source = "updatedAt")
    @Mapping(target = "rating", source = "rating")
    @Mapping(target = "cnh", source = "cnh")
    @Mapping(target = "available", source = "available")
    @Mapping(target = "vehicle", source = "vehicle")
    DeliveryManDto deliveryManToDeliveryManDto(DeliveryMan deliveryMan);

    // Mapeamento inverso de AdminDto para Admin
    @InheritInverseConfiguration
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "updatedAt", source = "updatedAt")
    Admin adminDtoToAdmin(AdminDto adminDto);

    // Mapeamento inverso de DeliveryManDto para DeliveryMan
    @InheritInverseConfiguration
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "updatedAt", source = "updatedAt")
    DeliveryMan deliveryManDtoToDeliveryMan(DeliveryManDto deliveryManDto);

    // Mapeamento de Vehicle
    VehicleDto vehicleToVehicleDto(Vehicle vehicle);

    Vehicle vehicleDtoToVehicle(VehicleDto vehicleDto);

    // Conversores de data
    default LocalDateTime map(Instant instant) {
        return instant != null ? LocalDateTime.ofInstant(instant, ZoneId.systemDefault()) : null;
    }

    default Instant map(LocalDateTime localDateTime) {
        return localDateTime != null ? localDateTime.atZone(ZoneId.systemDefault()).toInstant() : null;
    }
}