package com.freetech.items.itemservice.infraestructure.adapters.out.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@Setter
@Entity
@Table(schema="public", name="items")
public class ItemEntity {
    @Id
    @SequenceGenerator(name = "ITM_GENERATOR", sequenceName = "public.seq_items", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ITM_GENERATOR")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "total", nullable = false)
    private BigDecimal total;
}
