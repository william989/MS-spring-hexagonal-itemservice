package com.freetech.items.itemservice.application.clients;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class QueryProductDto {
    private Long id;
    private BigDecimal price;
}
