package com.santt4na.rapidinner.dto.accountTypesDto;

import java.math.BigDecimal;

import com.santt4na.rapidinner.dto.deliveryDto.VehicleDto;
import com.santt4na.rapidinner.enums.UserRole;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRequestDto(
        @NotBlank String name,
        @Email String email,
        @NotNull UserRole role,

        Boolean active,
        String lastLogin,

        @DecimalMin("0.0") @DecimalMax("5.0") BigDecimal rating,
        String cnh,
        Boolean available,
        VehicleDto vehicle) {

    @AssertTrue(message = "CNH, Vehicle e Rating são obrigatórios para DELIVERYMAN")
    public boolean isDeliveryManFieldsValid() {
        return role != UserRole.ROLE_DELIVERYMAN || (cnh != null && !cnh.isBlank() &&
                vehicle != null &&
                rating != null);
    }
}