package com.challenge.agileenginechallenge.utils.mappers;

import com.challenge.agileenginechallenge.dto.ProductDTO;
import com.challenge.agileenginechallenge.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO toProductDTO(Product product);
    Product toProduct(ProductDTO productDTO);
}
