package org.estore.estore.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOrderResponse {
    private String orderId;
    private String orderStatus;
    private String message;
}
