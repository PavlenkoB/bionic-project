package ua.ho.godex.dao.jpa;


import javax.persistence.EntityManager;
import java.util.Optional;

/**
 * Creator: Pavlenko Bohdan
 * Date: 03.09.2017
 * Project: supStore
 */
public abstract class JpaGenericDaoImpl<T> {

    private final Class<T> attributeClass;
    private final EntityManager entityManager;

    public JpaGenericDaoImpl(EntityManager entityManager, Class<T> targetClass) {
        this.entityManager = entityManager;
        attributeClass = targetClass;
    }

    public Optional<T> getById(Integer attributeId) {
        T attribute = entityManager.find(attributeClass, attributeId);
        return Optional.ofNullable(attribute);
    }
}
