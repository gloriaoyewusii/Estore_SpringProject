package org.estore.estore.service;

import org.estore.estore.dto.request.AddProductRequest;
import org.estore.estore.dto.request.UpdateProductRequest;
import org.estore.estore.dto.response.AddProductResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ProductServiceTest {
    @Autowired
    private ProductService productService;
    @Test
    public void testCanAddProduct() {
        AddProductRequest productRequest = new AddProductRequest();
        AddProductResponse productResponse = productService.add(productRequest);
        assertThat(productResponse).isNotNull();
//        assertThat(productResponse.getMedia()).isNotEmpty();

    }

    @Test
    public void updateProduct(){
        UpdateProductRequest updateProductRequest = new UpdateProductRequest();
        updateProductRequest.setName("");

    }

}
