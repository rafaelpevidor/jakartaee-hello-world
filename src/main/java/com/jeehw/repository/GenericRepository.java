package com.jeehw.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public abstract class GenericRepository<E> {

    private final Class<E> type;

    @PersistenceContext
    private EntityManager entityManager;

    protected GenericRepository(Class<E> type) {
        this.type = type;
    }

    public E save(E entity) {
        return entityManager.merge(entity);
    }

    public E findOne(String id) {
        return entityManager.find(type, id);
    }

    public void delete(E entity) {
        this.entityManager.remove(this.entityManager.merge(entity));
    }

    public List<E> findAll() {
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<E> cq = builder.createQuery(type);
        Root<E> root = cq.from(type);
        cq.select(root);
        return this.entityManager.createQuery(cq).getResultList();
    }

}
