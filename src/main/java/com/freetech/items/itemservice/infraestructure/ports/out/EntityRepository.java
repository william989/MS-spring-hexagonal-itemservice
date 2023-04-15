package com.freetech.items.itemservice.infraestructure.ports.out;

public interface EntityRepository {
    <T> T save(T entity);
}
