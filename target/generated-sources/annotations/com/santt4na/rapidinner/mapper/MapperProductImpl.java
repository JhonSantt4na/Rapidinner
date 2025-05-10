package com.santt4na.rapidinner.mapper;

import com.santt4na.rapidinner.dto.businessDto.OrderItemsDto;
import com.santt4na.rapidinner.dto.businessDto.ProductDto;
import com.santt4na.rapidinner.model.business.OrderItems;
import com.santt4na.rapidinner.model.business.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-24T20:23:57-0300",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.41.0.z20250213-2037, environment: Java 21.0.6 (Ubuntu)"
)
@Component
public class MapperProductImpl implements MapperProduct {

    @Override
    public Product productToProductDto(Product product) {
        if ( product == null ) {
            return null;
        }

        Product product1 = new Product();

        product1.setDescription( product.getDescription() );
        product1.setId( product.getId() );
        product1.setName( product.getName() );
        List<OrderItems> list = product.getOrderItems();
        if ( list != null ) {
            product1.setOrderItems( new ArrayList<OrderItems>( list ) );
        }
        product1.setPrice( product.getPrice() );
        product1.setStock( product.getStock() );

        return product1;
    }

    @Override
    public ProductDto productDtoToProduct(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        ProductDto productDto1 = new ProductDto();

        productDto1.setDescription( productDto.getDescription() );
        productDto1.setName( productDto.getName() );
        List<OrderItemsDto> list = productDto.getOrderItems();
        if ( list != null ) {
            productDto1.setOrderItems( new ArrayList<OrderItemsDto>( list ) );
        }
        productDto1.setPrice( productDto.getPrice() );
        productDto1.setStock( productDto.getStock() );

        return productDto1;
    }
}
