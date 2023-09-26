package com.jeehw.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public abstract class GenericRepository<E> {

    @PersistenceContext
    private EntityManager entityManager;

    public E save(E entity) {
        return entityManager.merge(entity);
    }

    public E findOne(String id) {
        return entityManager.find(getEntityClass(), id);
    }

    public void delete(E entity) {
        this.entityManager.remove(this.entityManager.merge(entity));
    }

    public List<E> findAll() {
        var clazz = getEntityClass();
        return entityManager.createQuery("from %s obj".formatted(clazz.getSimpleName()), clazz).getResultList();
    }

    private Class<E> getEntityClass() {
        return (Class<E>) this.getClass().getGenericSuperclass().getClass();
    }
}
