package org.estore.estore.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemRequest {
    @JsonProperty("item_id")
    private String id;
    private int quantity;

    public ItemRequest(String id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }
}
