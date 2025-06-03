package org.estore.estore.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Cart {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private String id;
    @OneToMany
    private List<Item> items;
}
