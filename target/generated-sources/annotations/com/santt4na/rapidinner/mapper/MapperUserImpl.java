package com.santt4na.rapidinner.mapper;

import com.santt4na.rapidinner.dto.accountTypesDto.AdminDto;
import com.santt4na.rapidinner.dto.accountTypesDto.DeliveryManDto;
import com.santt4na.rapidinner.dto.deliveryDto.VehicleDto;
import com.santt4na.rapidinner.model.accountTypes.Admin;
import com.santt4na.rapidinner.model.accountTypes.DeliveryMan;
import com.santt4na.rapidinner.model.delivery.Vehicle;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-22T00:00:57-0300",
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

        adminDto.setCreatedAt( map( admin.getCreatedAt() ) );
        adminDto.setUpdatedAt( map( admin.getUpdatedAt() ) );
        adminDto.setActive( admin.isActive() );
        adminDto.setLastLogin( admin.getLastLogin() );
        adminDto.setEmail( admin.getEmail() );
        adminDto.setId( admin.getId() );
        adminDto.setName( admin.getName() );
        adminDto.setRole( admin.getRole() );

        return adminDto;
    }

    @Override
    public DeliveryManDto deliveryManToDeliveryManDto(DeliveryMan deliveryMan) {
        if ( deliveryMan == null ) {
            return null;
        }

        DeliveryManDto deliveryManDto = new DeliveryManDto();

        deliveryManDto.setCreatedAt( map( deliveryMan.getCreatedAt() ) );
        deliveryManDto.setUpdatedAt( map( deliveryMan.getUpdatedAt() ) );
        deliveryManDto.setRating( deliveryMan.getRating() );
        deliveryManDto.setCnh( deliveryMan.getCnh() );
        deliveryManDto.setAvailable( deliveryMan.isAvailable() );
        deliveryManDto.setVehicle( deliveryMan.getVehicle() );
        deliveryManDto.setEmail( deliveryMan.getEmail() );
        deliveryManDto.setId( deliveryMan.getId() );
        deliveryManDto.setName( deliveryMan.getName() );
        deliveryManDto.setRole( deliveryMan.getRole() );

        return deliveryManDto;
    }

    @Override
    public Admin adminDtoToAdmin(AdminDto adminDto) {
        if ( adminDto == null ) {
            return null;
        }

        Admin admin = new Admin();

        admin.setCreatedAt( map( adminDto.getCreatedAt() ) );
        admin.setUpdatedAt( map( adminDto.getUpdatedAt() ) );
        admin.setActive( adminDto.isActive() );
        admin.setLastLogin( adminDto.getLastLogin() );
        admin.setEmail( adminDto.getEmail() );
        admin.setId( adminDto.getId() );
        admin.setName( adminDto.getName() );
        admin.setRole( adminDto.getRole() );

        return admin;
    }

    @Override
    public DeliveryMan deliveryManDtoToDeliveryMan(DeliveryManDto deliveryManDto) {
        if ( deliveryManDto == null ) {
            return null;
        }

        DeliveryMan deliveryMan = new DeliveryMan();

        deliveryMan.setCreatedAt( map( deliveryManDto.getCreatedAt() ) );
        deliveryMan.setUpdatedAt( map( deliveryManDto.getUpdatedAt() ) );
        deliveryMan.setRating( deliveryManDto.getRating() );
        deliveryMan.setCnh( deliveryManDto.getCnh() );
        deliveryMan.setAvailable( deliveryManDto.isAvailable() );
        deliveryMan.setVehicle( deliveryManDto.getVehicle() );
        deliveryMan.setEmail( deliveryManDto.getEmail() );
        deliveryMan.setId( deliveryManDto.getId() );
        deliveryMan.setName( deliveryManDto.getName() );
        deliveryMan.setRole( deliveryManDto.getRole() );

        return deliveryMan;
    }

    @Override
    public VehicleDto vehicleToVehicleDto(Vehicle vehicle) {
        if ( vehicle == null ) {
            return null;
        }

        String vehicleType = null;
        String color = null;
        String model = null;
        String plate = null;

        vehicleType = vehicle.getVehicleType();
        color = vehicle.getColor();
        model = vehicle.getModel();
        plate = vehicle.getPlate();

        VehicleDto vehicleDto = new VehicleDto( vehicleType, color, model, plate );

        return vehicleDto;
    }

    @Override
    public Vehicle vehicleDtoToVehicle(VehicleDto vehicleDto) {
        if ( vehicleDto == null ) {
            return null;
        }

        Vehicle vehicle = new Vehicle();

        vehicle.setColor( vehicleDto.color() );
        vehicle.setModel( vehicleDto.model() );
        vehicle.setPlate( vehicleDto.plate() );
        vehicle.setVehicleType( vehicleDto.vehicleType() );

        return vehicle;
    }
}
