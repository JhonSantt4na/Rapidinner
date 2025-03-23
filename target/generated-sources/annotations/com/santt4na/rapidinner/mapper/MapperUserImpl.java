package com.santt4na.rapidinner.mapper;

import com.santt4na.rapidinner.dto.accountTypesDto.AdminDto;
import com.santt4na.rapidinner.dto.accountTypesDto.CustomerDto;
import com.santt4na.rapidinner.dto.accountTypesDto.DeliveryManDto;
import com.santt4na.rapidinner.dto.accountTypesDto.MerchantDto;
import com.santt4na.rapidinner.dto.deliveryDto.AddressDto;
import com.santt4na.rapidinner.dto.deliveryDto.VehicleDto;
import com.santt4na.rapidinner.enums.AddressType;
import com.santt4na.rapidinner.enums.VehicleTypeEnum;
import com.santt4na.rapidinner.model.accountTypes.Admin;
import com.santt4na.rapidinner.model.accountTypes.Customer;
import com.santt4na.rapidinner.model.accountTypes.DeliveryMan;
import com.santt4na.rapidinner.model.accountTypes.Merchant;
import com.santt4na.rapidinner.model.delivery.AddressApp;
import com.santt4na.rapidinner.model.delivery.Vehicle;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-23T12:08:47-0300",
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
        adminDto.setEmail( admin.getEmail() );
        adminDto.setId( admin.getId() );
        adminDto.setName( admin.getName() );
        adminDto.setRole( admin.getRole() );
        adminDto.setUpdatedAt( map( admin.getUpdatedAt() ) );
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

        admin.setCreatedAt( map( adminDto.getCreatedAt() ) );
        admin.setEmail( adminDto.getEmail() );
        admin.setId( adminDto.getId() );
        admin.setName( adminDto.getName() );
        admin.setRole( adminDto.getRole() );
        admin.setUpdatedAt( map( adminDto.getUpdatedAt() ) );
        admin.setActive( adminDto.isActive() );
        admin.setLastLogin( adminDto.getLastLogin() );

        return admin;
    }

    @Override
    public DeliveryManDto deliveryManToDeliveryManDto(DeliveryMan deliveryMan) {
        if ( deliveryMan == null ) {
            return null;
        }

        DeliveryManDto deliveryManDto = new DeliveryManDto();

        deliveryManDto.setCreatedAt( map( deliveryMan.getCreatedAt() ) );
        deliveryManDto.setEmail( deliveryMan.getEmail() );
        deliveryManDto.setId( deliveryMan.getId() );
        deliveryManDto.setName( deliveryMan.getName() );
        deliveryManDto.setRole( deliveryMan.getRole() );
        deliveryManDto.setUpdatedAt( map( deliveryMan.getUpdatedAt() ) );
        deliveryManDto.setAvailable( deliveryMan.isAvailable() );
        deliveryManDto.setCnh( deliveryMan.getCnh() );
        deliveryManDto.setRating( deliveryMan.getRating() );
        deliveryManDto.setVehicle( deliveryMan.getVehicle() );

        return deliveryManDto;
    }

    @Override
    public DeliveryMan deliveryManDtoToDeliveryMan(DeliveryManDto deliveryManDto) {
        if ( deliveryManDto == null ) {
            return null;
        }

        DeliveryMan deliveryMan = new DeliveryMan();

        deliveryMan.setCreatedAt( map( deliveryManDto.getCreatedAt() ) );
        deliveryMan.setEmail( deliveryManDto.getEmail() );
        deliveryMan.setId( deliveryManDto.getId() );
        deliveryMan.setName( deliveryManDto.getName() );
        deliveryMan.setRole( deliveryManDto.getRole() );
        deliveryMan.setUpdatedAt( map( deliveryManDto.getUpdatedAt() ) );
        deliveryMan.setAvailable( deliveryManDto.isAvailable() );
        deliveryMan.setCnh( deliveryManDto.getCnh() );
        deliveryMan.setRating( deliveryManDto.getRating() );
        deliveryMan.setVehicle( deliveryManDto.getVehicle() );

        return deliveryMan;
    }

    @Override
    public CustomerDto customerToCustomerDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setAddresses( addressTypeAddressAppMapToAddressTypeAddressDtoMap( customer.getAddresses() ) );
        customerDto.setCreatedAt( map( customer.getCreatedAt() ) );
        customerDto.setEmail( customer.getEmail() );
        customerDto.setId( customer.getId() );
        customerDto.setName( customer.getName() );
        customerDto.setRole( customer.getRole() );
        customerDto.setUpdatedAt( map( customer.getUpdatedAt() ) );
        customerDto.setCpf( customer.getCpf() );

        return customerDto;
    }

    @Override
    public Customer customerDtoToCustomer(CustomerDto customerDto) {
        if ( customerDto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setAddresses( addressTypeAddressDtoMapToAddressTypeAddressAppMap( customerDto.getAddresses() ) );
        customer.setCreatedAt( map( customerDto.getCreatedAt() ) );
        customer.setEmail( customerDto.getEmail() );
        customer.setId( customerDto.getId() );
        customer.setName( customerDto.getName() );
        customer.setRole( customerDto.getRole() );
        customer.setUpdatedAt( map( customerDto.getUpdatedAt() ) );
        customer.setCpf( customerDto.getCpf() );

        return customer;
    }

    @Override
    public MerchantDto merchantToMerchantDto(Merchant merchant) {
        if ( merchant == null ) {
            return null;
        }

        MerchantDto merchantDto = new MerchantDto();

        merchantDto.setBusinessAddress( merchant.getBusinessAddress() );
        merchantDto.setCreatedAt( map( merchant.getCreatedAt() ) );
        merchantDto.setEmail( merchant.getEmail() );
        merchantDto.setName( merchant.getName() );
        merchantDto.setRole( merchant.getRole() );
        merchantDto.setUpdatedAt( map( merchant.getUpdatedAt() ) );
        merchantDto.setCnpj( merchant.getCnpj() );
        merchantDto.setCompanyName( merchant.getCompanyName() );
        merchantDto.setId( merchant.getId() );

        return merchantDto;
    }

    @Override
    public Merchant merchantDtoToMerchant(MerchantDto merchantDto) {
        if ( merchantDto == null ) {
            return null;
        }

        Merchant merchant = new Merchant();

        merchant.setBusinessAddress( merchantDto.getBusinessAddress() );
        merchant.setCreatedAt( map( merchantDto.getCreatedAt() ) );
        merchant.setEmail( merchantDto.getEmail() );
        merchant.setId( merchantDto.getId() );
        merchant.setName( merchantDto.getName() );
        merchant.setRole( merchantDto.getRole() );
        merchant.setUpdatedAt( map( merchantDto.getUpdatedAt() ) );
        merchant.setCnpj( merchantDto.getCnpj() );
        merchant.setCompanyName( merchantDto.getCompanyName() );

        return merchant;
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
    public AddressDto addressAppToAddressDto(AddressApp addressApp) {
        if ( addressApp == null ) {
            return null;
        }

        AddressDto addressDto = new AddressDto();

        addressDto.setStreet( addressApp.getStreet() );
        addressDto.setCity( addressApp.getCity() );
        addressDto.setState( addressApp.getState() );
        addressDto.setNumber( addressApp.getNumber() );
        addressDto.setZipCode( addressApp.getZipCode() );
        addressDto.setCountry( addressApp.getCountry() );
        addressDto.setPrimary( addressApp.isPrimary() );
        addressDto.setComplement( addressApp.getComplement() );
        addressDto.setReferencePoint( addressApp.getReferencePoint() );

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

    protected Map<AddressType, AddressApp> addressTypeAddressDtoMapToAddressTypeAddressAppMap(Map<AddressType, AddressDto> map) {
        if ( map == null ) {
            return null;
        }

        Map<AddressType, AddressApp> map1 = LinkedHashMap.newLinkedHashMap( map.size() );

        for ( java.util.Map.Entry<AddressType, AddressDto> entry : map.entrySet() ) {
            AddressType key = entry.getKey();
            AddressApp value = addressDtoToAddress( entry.getValue() );
            map1.put( key, value );
        }

        return map1;
    }
}
