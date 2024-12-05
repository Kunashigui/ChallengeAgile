package com.challenge.agileenginechallenge.service;

import com.challenge.agileenginechallenge.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface ProductService {

    List<ProductDTO> getProducts();
    ProductDTO getProductById(UUID id);
    ProductDTO createProduct(ProductDTO productDTO);
    ProductDTO updateProduct(UUID id, ProductDTO productDTO);
    void deleteProduct(UUID id);
    
}
