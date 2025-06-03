package org.estore.estore.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
public class AddProductResponse {
    private String name;
    private String description;
    private BigDecimal price;
    private Set<String> media;
}
