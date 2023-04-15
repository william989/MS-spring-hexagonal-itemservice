package com.freetech.items.itemservice.infraestructure.adapters.in.http.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewItemDto {
    private Long id;
    private Long productId;
    private Integer quantity;
}
