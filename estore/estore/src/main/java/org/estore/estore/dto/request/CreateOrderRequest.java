package org.estore.estore.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateOrderRequest {
    private List<ItemRequest> items;
    private String cartId;
}
