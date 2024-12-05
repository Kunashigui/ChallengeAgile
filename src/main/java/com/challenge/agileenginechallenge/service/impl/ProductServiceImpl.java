package com.challenge.agileenginechallenge.service.impl;

import com.challenge.agileenginechallenge.dto.ProductDTO;
import com.challenge.agileenginechallenge.exception.ProductNotFoundException;
import com.challenge.agileenginechallenge.model.Product;
import com.challenge.agileenginechallenge.repository.ProductRepository;
import com.challenge.agileenginechallenge.service.ProductService;
import com.challenge.agileenginechallenge.utils.mappers.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDTO> getProducts() {

        return productRepository.findAll().stream().map(productMapper::toProductDTO).toList();
    }

    @Override
    public ProductDTO getProductById(UUID id) {

        return productRepository.findById(id).map(productMapper::toProductDTO)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {

        Product product = productMapper.toProduct(productDTO);
        return productMapper.toProductDTO(productRepository.save(product));
    }

    @Override
    public ProductDTO updateProduct(UUID id, ProductDTO productDTO) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setStock(productDTO.getStock());

        return productMapper.toProductDTO(productRepository.save(product));
    }

    @Override
    public void deleteProduct(UUID id) {
        productRepository.deleteById(id);
    }
}
