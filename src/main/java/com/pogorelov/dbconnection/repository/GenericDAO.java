package com.pogorelov.dbconnection.repository;

import lombok.Getter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;

public abstract class GenericDAO<T, K> {

    public abstract Class<T> getEntityClass();


    @Getter
    private final EntityManager entityManager;

    GenericDAO() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-test");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void save(T entity) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
    }

    public void update(T entity, K id) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        T entityFromDB = em.find(getEntityClass(), id);
        em.merge(entity);
        em.persist(entityFromDB);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteDepartment(K id) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        T entityFromDB = em.find(getEntityClass(),id);
        em.remove(entityFromDB);
        em.getTransaction().commit();
        em.close();
    }

    public Optional<T> findById(K id) {
        EntityManager em = getEntityManager();
        T entityFromDB = em.find(getEntityClass(), id);
        em.close();
        return Optional.ofNullable(entityFromDB);
    }

    public List<T> findAll() {
        EntityManager em = getEntityManager();
        List<T> entityList = em.createQuery("FROM " + getEntityClass().getSimpleName()).getResultList();
        em.close();
        return entityList;
    }
}
