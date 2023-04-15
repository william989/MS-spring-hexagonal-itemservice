package com.freetech.items.itemservice.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@Setter
public class Item {
    private Long id;
    private Long productId;
    private Integer quantity;
    private BigDecimal total;
}
