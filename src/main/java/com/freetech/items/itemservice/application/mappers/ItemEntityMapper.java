package com.freetech.items.itemservice.application.mappers;

import com.freetech.items.itemservice.domain.Item;
import com.freetech.items.itemservice.infraestructure.adapters.out.entities.ItemEntity;

import java.util.function.Function;
import java.util.stream.Stream;

public class ItemEntityMapper {
    public static ItemEntity toEntity(Item item) {
        if (item == null) return null;
        return Stream.of(item).map(toEntity()).findFirst().get();
    }

    public static Item toDomain(ItemEntity itemEntity) {
        if (itemEntity == null) return null;
        return Stream.of(itemEntity).map(toDomain()).findFirst().get();
    }

    private static Function<Item, ItemEntity> toEntity() {
        return item -> {
            var itemEntity = new ItemEntity();
            itemEntity.setProductId(item.getProductId());
            itemEntity.setQuantity(item.getQuantity());
            itemEntity.setTotal(item.getTotal());
            return itemEntity;
        };
    }

    private static Function<ItemEntity, Item> toDomain() {
        return itemEntity -> {
            var item = new Item();
            item.setId(itemEntity.getId());
            item.setProductId(itemEntity.getProductId());
            item.setQuantity(itemEntity.getQuantity());
            item.setTotal(itemEntity.getTotal());
            return item;
        };
    }
}
