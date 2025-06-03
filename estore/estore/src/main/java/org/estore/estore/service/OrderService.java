package org.estore.estore.service;

import org.estore.estore.dto.request.CreateOrderRequest;
import org.estore.estore.dto.response.CreateOrderResponse;

public interface OrderService {
    CreateOrderResponse create(CreateOrderRequest order);
}
