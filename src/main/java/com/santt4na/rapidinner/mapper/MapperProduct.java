package com.santt4na.rapidinner.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import com.santt4na.rapidinner.dto.businessDto.ProductDto;
import com.santt4na.rapidinner.model.business.Product;

@Component
@Mapper(componentModel = "spring")
public interface MapperProduct {

  MapperProduct INSTANCE = Mappers.getMapper(MapperProduct.class);

  Product productToProductDto(Product product);

  ProductDto productDtoToProduct(ProductDto productDto);

}
