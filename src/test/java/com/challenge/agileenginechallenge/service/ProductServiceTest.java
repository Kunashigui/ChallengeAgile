package com.challenge.agileenginechallenge.service;

import com.challenge.agileenginechallenge.dto.ProductDTO;
import com.challenge.agileenginechallenge.model.Product;
import com.challenge.agileenginechallenge.repository.ProductRepository;
import com.challenge.agileenginechallenge.service.impl.ProductServiceImpl;
import com.challenge.agileenginechallenge.utils.mappers.ProductMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class ProductServiceTest {

    @Mock
    ProductRepository productRepository;

    @Mock
    ProductMapper productMapper;

    @InjectMocks
    ProductServiceImpl productService;

    @BeforeEach
    void setUp() {
        Mockito.when(productRepository.findAll()).thenReturn(List.of(new Product()));
        Mockito.when(productRepository.save(any())).thenReturn(new Product());

        Mockito.when(productMapper.toProductDTO(any())).thenReturn(new ProductDTO());
        Mockito.when(productMapper.toProduct(any())).thenReturn(new Product());
    }

    @Test
    void getProducts() {
        List<ProductDTO> productDTOList = productService.getProducts();
        assertEquals(1, productDTOList.size());
    }

    @Test
    void getProductById() {
        UUID id = UUID.randomUUID();
        Mockito.when(productRepository.findById(id)).thenReturn(Optional.of(new Product()));

        ProductDTO productDTO = productService.getProductById(id);
        assertNotNull(productDTO);
    }

    @Test
    void getProductByIdNotFound() {
        Mockito.when(productRepository.findById(any())).thenReturn(Optional.empty());
        assertThrows(Exception.class, () -> productService.getProductById(any()));
    }

    @Test
    void createProduct() {
        ProductDTO productDTO = productService.createProduct(new ProductDTO());
        assertNotNull(productDTO);
    }

    @Test
    void updateProduct() {
        Mockito.when(productRepository.findById(any())).thenReturn(Optional.of(new Product()));
        ProductDTO productDTO = productService.updateProduct(any(), new ProductDTO());
        assertNotNull(productDTO);
    }

    @Test
    void updateProductNotFound() {
        Mockito.when(productRepository.findById(any())).thenReturn(Optional.empty());
        assertThrows(Exception.class, () -> productService.updateProduct(any(), new ProductDTO()));
    }

    @Test
    void deleteProduct() {
        productService.deleteProduct(any());
        Mockito.verify(productRepository, Mockito.times(1)).deleteById(any());
    }
}