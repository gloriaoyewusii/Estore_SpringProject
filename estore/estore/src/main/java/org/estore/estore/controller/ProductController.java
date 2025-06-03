package org.estore.estore.controller;

import lombok.AllArgsConstructor;
import org.estore.estore.dto.request.AddProductRequest;
import org.estore.estore.dto.response.AddProductResponse;
import org.estore.estore.model.Product;
import org.estore.estore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@RestController
@RequestMapping("/api/v1/product")

public class ProductController {

    @Autowired
    private ProductService productService;

    @PutMapping(consumes = MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<AddProductResponse> updateProduct(@ModelAttribute AddProductRequest product) {
        return ResponseEntity.status(CREATED)
                .body(productService.add(product));
    }

}
