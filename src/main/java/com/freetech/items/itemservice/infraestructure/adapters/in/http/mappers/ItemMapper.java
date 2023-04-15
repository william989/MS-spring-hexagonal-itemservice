package com.freetech.items.itemservice.infraestructure.adapters.in.http.mappers;

import com.freetech.items.itemservice.domain.Item;
import com.freetech.items.itemservice.infraestructure.adapters.in.http.dtos.NewItemDto;

import java.util.function.Function;
import java.util.stream.Stream;

public class ItemMapper {
    public static <T> Item toDomain(T dto) {
        if (dto == null) return null;
        return Stream.of(dto).map(toDomain()).findFirst().get();
    }

    public static <T> T toDto(Item item, Class<T> clazz) {
        if (item == null) return null;
        return (T) Stream.of(item).map(toDto(clazz)).findFirst().get();
    }

    private static <T> Function<T, Item> toDomain() {
        return dto -> {
            var item = new Item();
            if (dto instanceof NewItemDto) {
                var newItemDto = (NewItemDto) dto;
                item.setId(newItemDto.getId());
                item.setProductId(newItemDto.getProductId());
                item.setQuantity(newItemDto.getQuantity());
            }
            return item;
        };
    }

    private static <T> Function<Item, T> toDto(Class<T> clazz) {
        return product -> {
            try {
                var dto = clazz.getDeclaredConstructor().newInstance();
                if (dto instanceof NewItemDto) {
                    ((NewItemDto) dto).setId(product.getId());
                    ((NewItemDto) dto).setProductId(product.getProductId());
                    ((NewItemDto) dto).setQuantity(product.getQuantity());
                }
                return dto;
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        };
    }
}
