package org.estore.estore.service;

import lombok.AllArgsConstructor;
import org.estore.estore.dto.request.AddProductRequest;
import org.estore.estore.dto.response.AddProductResponse;
import org.estore.estore.exception.ProductNotFoundException;
import org.estore.estore.model.Product;
import org.estore.estore.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Override
    public AddProductResponse add(AddProductRequest productRequest) {
        Product product = modelMapper.map(productRequest, Product.class);
        Product savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct, AddProductResponse.class);
    }

    @Override
    public Product getProductBy(String id) {
        return productRepository.findById(id)
                .orElseThrow(()->new ProductNotFoundException("product not found"));
    }
}
