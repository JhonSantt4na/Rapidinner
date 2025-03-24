package com.santt4na.rapidinner.mapper;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

import com.santt4na.rapidinner.dto.deliveryDto.AddressDto;
import com.santt4na.rapidinner.dto.deliveryDto.VehicleDto;
import com.santt4na.rapidinner.dto.typesaccountDto.AdminDto;
import com.santt4na.rapidinner.dto.typesaccountDto.CustomerDto;
import com.santt4na.rapidinner.dto.typesaccountDto.DeliveryManDto;
import com.santt4na.rapidinner.dto.typesaccountDto.MerchantDto;
import com.santt4na.rapidinner.dto.typesaccountDto.UserDto;
import com.santt4na.rapidinner.model.delivery.AddressApp;
import com.santt4na.rapidinner.model.delivery.Vehicle;
import com.santt4na.rapidinner.model.typesaccount.Admin;
import com.santt4na.rapidinner.model.typesaccount.Customer;
import com.santt4na.rapidinner.model.typesaccount.DeliveryMan;
import com.santt4na.rapidinner.model.typesaccount.Merchant;
import com.santt4na.rapidinner.model.typesaccount.User;

@Mapper(componentModel = "spring")
@Component
public interface MapperUser {

    default UserDto toDto(User user) {
        if (user instanceof Admin) {
            return adminToAdminDto((Admin) user);
        } else if (user instanceof DeliveryMan) {
            return deliveryManToDeliveryManDto((DeliveryMan) user);
        } else if (user instanceof Customer) {
            return customerToCustomerDto((Customer) user);
        } else if (user instanceof Merchant) {
            return merchantToMerchantDto((Merchant) user);
        }
        throw new IllegalArgumentException("Tipo de usuário não suportado: " + user.getClass());
    }

    default User toEntity(UserDto userDto) {
        if (userDto instanceof AdminDto) {
            return adminDtoToAdmin((AdminDto) userDto);
        } else if (userDto instanceof DeliveryManDto) {
            return deliveryManDtoToDeliveryMan((DeliveryManDto) userDto);
        } else if (userDto instanceof CustomerDto) {
            return customerDtoToCustomer((CustomerDto) userDto);
        } else if (userDto instanceof MerchantDto) {
            return merchantDtoToMerchant((MerchantDto) userDto);
        }
        throw new IllegalArgumentException("Tipo de DTO não suportado: " + userDto.getClass());
    }

    // Admin
    AdminDto adminToAdminDto(Admin admin);

    Admin adminDtoToAdmin(AdminDto adminDto);

    // DeliveryMan
    DeliveryManDto deliveryManToDeliveryManDto(DeliveryMan deliveryMan);

    DeliveryMan deliveryManDtoToDeliveryMan(DeliveryManDto deliveryManDto);

    // Customer
    @Mapping(target = "addresses", source = "addresses")
    CustomerDto customerToCustomerDto(Customer customer);

    @Mapping(target = "addresses", source = "addresses")
    Customer customerDtoToCustomer(CustomerDto customerDto);

    // Merchant
    @Mapping(target = "businessAddress", source = "businessAddress")
    MerchantDto merchantToMerchantDto(Merchant merchant);

    @Mapping(target = "businessAddress", source = "businessAddress")
    Merchant merchantDtoToMerchant(MerchantDto merchantDto);

    // Vehicle
    VehicleDto vehicleToVehicleDto(Vehicle vehicle);

    Vehicle vehicleDtoToVehicle(VehicleDto vehicleDto);

    // Address Mapping
    @Mappings({
            @Mapping(target = "street", source = "street"),
            @Mapping(target = "city", source = "city"),
            @Mapping(target = "state", source = "state"),
            @Mapping(target = "number", source = "number"),
            @Mapping(target = "zipCode", source = "zipCode"),
            @Mapping(target = "country", source = "country"),
            @Mapping(target = "primary", source = "primary"),
            @Mapping(target = "complement", source = "complement"),
            @Mapping(target = "referencePoint", source = "referencePoint")
    })
    AddressApp addressDtoToAddress(AddressDto addressDto);

    @Mappings({
            @Mapping(target = "street", source = "street"),
            @Mapping(target = "city", source = "city"),
            @Mapping(target = "state", source = "state"),
            @Mapping(target = "number", source = "number"),
            @Mapping(target = "zipCode", source = "zipCode"),
            @Mapping(target = "country", source = "country"),
            @Mapping(target = "primary", source = "primary"),
            @Mapping(target = "complement", source = "complement"),
            @Mapping(target = "referencePoint", source = "referencePoint")
    })
    AddressDto addressAppToAddressDto(AddressApp addressApp);

    // Conversores de data
    default LocalDateTime map(Instant instant) {
        return instant != null ? LocalDateTime.ofInstant(instant, ZoneId.systemDefault()) : null;
    }

    default Instant map(LocalDateTime localDateTime) {
        return localDateTime != null ? localDateTime.atZone(ZoneId.systemDefault()).toInstant() : null;
    }
}