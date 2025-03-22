package com.santt4na.rapidinner.mapper;

import com.santt4na.rapidinner.dto.accountTypesDTO.AdminDto;
import com.santt4na.rapidinner.dto.accountTypesDTO.DeliveryManDto;
import com.santt4na.rapidinner.model.accountTypes.Admin;
import com.santt4na.rapidinner.model.accountTypes.DeliveryMan;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-21T22:04:18-0300",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.41.0.z20250213-2037, environment: Java 21.0.6 (Ubuntu)"
)
@Component
public class MapperUserImpl implements MapperUser {

    @Override
    public AdminDto adminToAdminDto(Admin admin) {
        if ( admin == null ) {
            return null;
        }

        AdminDto adminDto = new AdminDto();

        adminDto.setEmail( admin.getEmail() );
        adminDto.setName( admin.getName() );
        adminDto.setRole( admin.getRole() );
        adminDto.setActive( admin.isActive() );
        adminDto.setLastLogin( admin.getLastLogin() );

        return adminDto;
    }

    @Override
    public Admin adminDtoToAdmin(AdminDto adminDto) {
        if ( adminDto == null ) {
            return null;
        }

        Admin admin = new Admin();

        admin.setEmail( adminDto.getEmail() );
        admin.setName( adminDto.getName() );
        admin.setRole( adminDto.getRole() );
        admin.setActive( adminDto.isActive() );
        admin.setLastLogin( adminDto.getLastLogin() );

        return admin;
    }

    @Override
    public DeliveryMan deliveryManToDeliveryManDto(DeliveryMan deliveryMan) {
        if ( deliveryMan == null ) {
            return null;
        }

        DeliveryMan deliveryMan1 = new DeliveryMan();

        deliveryMan1.setCreatedAt( deliveryMan.getCreatedAt() );
        deliveryMan1.setEmail( deliveryMan.getEmail() );
        deliveryMan1.setId( deliveryMan.getId() );
        deliveryMan1.setName( deliveryMan.getName() );
        deliveryMan1.setRole( deliveryMan.getRole() );
        deliveryMan1.setUpdatedAt( deliveryMan.getUpdatedAt() );
        deliveryMan1.setAvailable( deliveryMan.isAvailable() );
        deliveryMan1.setCnh( deliveryMan.getCnh() );
        deliveryMan1.setRating( deliveryMan.getRating() );
        deliveryMan1.setVehicle( deliveryMan.getVehicle() );

        return deliveryMan1;
    }

    @Override
    public DeliveryManDto deliveryManDtoToDeliveryMan(DeliveryManDto deliveryManDto) {
        if ( deliveryManDto == null ) {
            return null;
        }

        DeliveryManDto deliveryManDto1 = new DeliveryManDto();

        deliveryManDto1.setEmail( deliveryManDto.getEmail() );
        deliveryManDto1.setName( deliveryManDto.getName() );
        deliveryManDto1.setRole( deliveryManDto.getRole() );
        deliveryManDto1.setAvailable( deliveryManDto.isAvailable() );
        deliveryManDto1.setCnh( deliveryManDto.getCnh() );
        deliveryManDto1.setRating( deliveryManDto.getRating() );
        deliveryManDto1.setVehicle( deliveryManDto.getVehicle() );

        return deliveryManDto1;
    }
}
