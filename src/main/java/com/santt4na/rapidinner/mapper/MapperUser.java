package com.santt4na.rapidinner.mapper;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.mapstruct.Mapper;

import com.santt4na.rapidinner.dto.accountTypesDTO.AdminDto;
import com.santt4na.rapidinner.dto.accountTypesDTO.DeliveryManDto;
import com.santt4na.rapidinner.model.accountTypes.Admin;
import com.santt4na.rapidinner.model.accountTypes.DeliveryMan;

@Mapper(componentModel = "spring")
public interface MapperUser {

    // Admin
    AdminDto adminToAdminDto(Admin admin);

    Admin adminDtoToAdmin(AdminDto adminDto);

    // DeliveryMan

    DeliveryMan deliveryManToDeliveryManDto(DeliveryMan deliveryMan);

    DeliveryManDto deliveryManDtoToDeliveryMan(DeliveryManDto deliveryManDto);

    default LocalDateTime map(Instant value) {
        if (value == null) {
            return null;
        }
        return LocalDateTime.ofInstant(value, ZoneId.systemDefault());
    }

    default Instant map(LocalDateTime value) {
        if (value == null) {
            return null;
        }
        return value.atZone(ZoneId.systemDefault()).toInstant();
    }
}
