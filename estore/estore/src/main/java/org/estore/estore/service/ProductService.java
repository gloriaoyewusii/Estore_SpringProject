package org.estore.estore.service;

import org.estore.estore.dto.request.AddProductRequest;
import org.estore.estore.dto.response.AddProductResponse;
import org.estore.estore.model.Product;

public interface ProductService {
    AddProductResponse add(AddProductRequest productRequest);
    Product getProductBy(String id);
}
