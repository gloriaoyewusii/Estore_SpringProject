package org.estore.estore.service;

import org.estore.estore.dto.request.CreateOrderRequest;
import org.estore.estore.dto.request.ItemRequest;
import org.estore.estore.dto.response.CreateOrderResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.estore.estore.util.TestUtils.buildCreateOrder;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    @Sql(scripts = {"/db/script.sql"})
    public void testCanPlaceOrder() {
        CreateOrderResponse createOrderResponse = orderService.
                create(buildCreateOrder());
        assertNotNull(createOrderResponse);
        assertThat(createOrderResponse.getMessage())
                .containsIgnoringCase("Order Placed Successfully");
    }



}
