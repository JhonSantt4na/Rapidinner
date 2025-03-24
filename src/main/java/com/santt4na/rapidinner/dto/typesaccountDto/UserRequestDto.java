package com.santt4na.rapidinner.dto.typesaccountDto;

import java.math.BigDecimal;
import java.util.Map;

import com.santt4na.rapidinner.dto.deliveryDto.AddressDto;
import com.santt4na.rapidinner.dto.deliveryDto.VehicleDto;
import com.santt4na.rapidinner.enums.AddressType;
import com.santt4na.rapidinner.enums.UserType;
import com.santt4na.rapidinner.model.delivery.AddressApp;

import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRequestDto(@NotBlank String name, @Email String email, @NotNull UserType role,

        Boolean active, String lastLogin,

        @DecimalMin("0.0") @DecimalMax("5.0") BigDecimal rating, String cnh, Boolean available, VehicleDto vehicle,

        String cpf, @Valid Map<AddressType, AddressDto> addresses,

        String cnpj,
        String companyName,
        AddressApp businessAddress) {

    @AssertTrue(message = "CNH, Vehicle e Rating são obrigatórios para DELIVERYMAN")
    public boolean isDeliveryManFieldsValid() {
        return role != UserType.ROLE_DELIVERYMAN || (cnh != null && !cnh.isBlank() &&
                vehicle != null &&
                rating != null);
    }

    @AssertTrue(message = "CPF e pelo menos um endereço são obrigatórios para CUSTOMER")
    public boolean isCustomerFieldsValid() {
        return role != UserType.ROLE_CUSTOMER || (cpf != null && !cpf.isBlank() &&
                addresses != null && !addresses.isEmpty());
    }

    @AssertTrue(message = "Endereços são obrigatórios para CUSTOMER")
    public boolean isCustomerAddressValid() {
        return role != UserType.ROLE_CUSTOMER || (addresses != null && !addresses.isEmpty());
    }

    @AssertTrue(message = "CNPJ e CompanyName sao obrigatorios para Merchant")
    public boolean isMerchantCnpjValid() {
        return role != UserType.ROLE_MERCHANT || (cnpj != null && !cnpj.isBlank() &&
                companyName != null && !companyName.isEmpty());
    }
}