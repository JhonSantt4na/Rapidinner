package com.santt4na.rapidinner.mapper;

import com.santt4na.rapidinner.dto.accountTypesDto.AdminDto;
import com.santt4na.rapidinner.dto.accountTypesDto.CustomerDto;
import com.santt4na.rapidinner.dto.accountTypesDto.DeliveryManDto;
import com.santt4na.rapidinner.dto.deliveryDto.AddressDto;
import com.santt4na.rapidinner.dto.deliveryDto.VehicleDto;
import com.santt4na.rapidinner.enums.AddressType;
import com.santt4na.rapidinner.enums.VehicleTypeEnum;
import com.santt4na.rapidinner.model.accountTypes.Admin;
import com.santt4na.rapidinner.model.accountTypes.Customer;
import com.santt4na.rapidinner.model.accountTypes.DeliveryMan;
import com.santt4na.rapidinner.model.delivery.AddressApp;
import com.santt4na.rapidinner.model.delivery.Vehicle;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-22T18:44:42-0300",
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
    public CustomerDto customerToCustomerDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setCpf( customer.getCpf() );
        customerDto.setAddresses( addressTypeAddressAppMapToAddressTypeAddressDtoMap( customer.getAddresses() ) );
        customerDto.setName( customer.getName() );
        customerDto.setEmail( customer.getEmail() );
        customerDto.setRole( customer.getRole() );
        customerDto.setCreatedAt( map( customer.getCreatedAt() ) );
        customerDto.setUpdatedAt( map( customer.getUpdatedAt() ) );
        customerDto.setId( customer.getId() );

        return customerDto;
    }

    @Override
    public Customer customerDtoToCustomer(CustomerDto customerDto) {
        if ( customerDto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setCpf( customerDto.getCpf() );
        customer.setName( customerDto.getName() );
        customer.setEmail( customerDto.getEmail() );
        customer.setRole( customerDto.getRole() );
        customer.setCreatedAt( map( customerDto.getCreatedAt() ) );
        customer.setUpdatedAt( map( customerDto.getUpdatedAt() ) );
        customer.setId( customerDto.getId() );

        return customer;
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

        VehicleDto vehicleDto = new VehicleDto();

        vehicleDto.setColor( vehicle.getColor() );
        vehicleDto.setModel( vehicle.getModel() );
        vehicleDto.setPlate( vehicle.getPlate() );
        if ( vehicle.getVehicleType() != null ) {
            vehicleDto.setVehicleType( vehicle.getVehicleType().name() );
        }

        return vehicleDto;
    }

    @Override
    public Vehicle vehicleDtoToVehicle(VehicleDto vehicleDto) {
        if ( vehicleDto == null ) {
            return null;
        }

        Vehicle vehicle = new Vehicle();

        vehicle.setColor( vehicleDto.getColor() );
        vehicle.setModel( vehicleDto.getModel() );
        vehicle.setPlate( vehicleDto.getPlate() );
        if ( vehicleDto.getVehicleType() != null ) {
            vehicle.setVehicleType( Enum.valueOf( VehicleTypeEnum.class, vehicleDto.getVehicleType() ) );
        }

        return vehicle;
    }

    @Override
    public AddressApp addressDtoToAddress(AddressDto addressDto) {
        if ( addressDto == null ) {
            return null;
        }

        AddressApp addressApp = new AddressApp();

        addressApp.setStreet( addressDto.getStreet() );
        addressApp.setCity( addressDto.getCity() );
        addressApp.setState( addressDto.getState() );
        addressApp.setNumber( addressDto.getNumber() );
        addressApp.setZipCode( addressDto.getZipCode() );
        addressApp.setCountry( addressDto.getCountry() );
        addressApp.setPrimary( addressDto.isPrimary() );
        addressApp.setComplement( addressDto.getComplement() );
        addressApp.setReferencePoint( addressDto.getReferencePoint() );

        return addressApp;
    }

    @Override
    public AddressApp addressToAddressDto(AddressDto addressDto) {
        if ( addressDto == null ) {
            return null;
        }

        AddressApp addressApp = new AddressApp();

        addressApp.setCity( addressDto.getCity() );
        addressApp.setComplement( addressDto.getComplement() );
        addressApp.setCountry( addressDto.getCountry() );
        addressApp.setNumber( addressDto.getNumber() );
        addressApp.setPrimary( addressDto.isPrimary() );
        addressApp.setReferencePoint( addressDto.getReferencePoint() );
        addressApp.setState( addressDto.getState() );
        addressApp.setStreet( addressDto.getStreet() );
        addressApp.setZipCode( addressDto.getZipCode() );

        return addressApp;
    }

    protected AddressDto addressAppToAddressDto(AddressApp addressApp) {
        if ( addressApp == null ) {
            return null;
        }

        AddressDto addressDto = new AddressDto();

        addressDto.setCity( addressApp.getCity() );
        addressDto.setComplement( addressApp.getComplement() );
        addressDto.setCountry( addressApp.getCountry() );
        addressDto.setNumber( addressApp.getNumber() );
        addressDto.setPrimary( addressApp.isPrimary() );
        addressDto.setReferencePoint( addressApp.getReferencePoint() );
        addressDto.setState( addressApp.getState() );
        addressDto.setStreet( addressApp.getStreet() );
        addressDto.setZipCode( addressApp.getZipCode() );

        return addressDto;
    }

    protected Map<AddressType, AddressDto> addressTypeAddressAppMapToAddressTypeAddressDtoMap(Map<AddressType, AddressApp> map) {
        if ( map == null ) {
            return null;
        }

        Map<AddressType, AddressDto> map1 = LinkedHashMap.newLinkedHashMap( map.size() );

        for ( java.util.Map.Entry<AddressType, AddressApp> entry : map.entrySet() ) {
            AddressType key = entry.getKey();
            AddressDto value = addressAppToAddressDto( entry.getValue() );
            map1.put( key, value );
        }

        return map1;
    }
}
