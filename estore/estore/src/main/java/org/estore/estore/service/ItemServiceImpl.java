package org.estore.estore.service;

import lombok.AllArgsConstructor;
import org.estore.estore.exception.ItemNotFoundException;
import org.estore.estore.model.Item;
import org.estore.estore.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    @Override
    public Item getItemBy(String id) {
        return itemRepository.findById(id)
                .orElseThrow(()->new ItemNotFoundException("item not found"));
    }
}
