package com.freetech.items.itemservice.infraestructure.adapters.out;

import com.freetech.items.itemservice.infraestructure.ports.out.EntityRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class PostgresRepository implements EntityRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public <T> T save(T entity) {
        entityManager.persist(entity);
        return entity;
    }
}
