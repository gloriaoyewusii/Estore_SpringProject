package org.estore.estore.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "media",
            joinColumns = @JoinColumn(name = "media_id",
                    referencedColumnName = "id"))
    private Set<String> media;
    private String category;
    private Long quantity;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
