package com.freetech.items.itemservice.infraestructure.ports.in;

import com.freetech.items.itemservice.domain.Item;

public interface CreateItemPort {
    Item createItem(Item item);
}
