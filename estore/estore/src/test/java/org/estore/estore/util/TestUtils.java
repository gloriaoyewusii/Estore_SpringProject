package org.estore.estore.util;

import org.estore.estore.dto.request.CreateOrderRequest;
import org.estore.estore.dto.request.ItemRequest;

import java.util.List;

public class TestUtils {

    public static CreateOrderRequest buildCreateOrder() {
        CreateOrderRequest order = new CreateOrderRequest();
        order.setItems(List.of(new ItemRequest("26943268-c87b-4d41-af5e-2cc83a6d2bc8", 2),
                new ItemRequest("1c7469de-63ec-4299-a160-3e03d3a2e3c8", 5)));
        order.setCartId("7cfbabc9-92f6-427d-b2b0-6acf84aaa881");
        return order;
    }
}
