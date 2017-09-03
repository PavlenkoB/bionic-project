package ua.ho.godex.dao.jpa;


import ua.ho.godex.dao.GenericDao;
import ua.ho.godex.domain.AbstaractGenericDomainObj;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

/**
 * Creator: Pavlenko Bohdan
 * Date: 03.09.2017
 * Project: supStore
 */
public abstract class JpaGenericDaoImpl<T extends AbstaractGenericDomainObj> implements GenericDao<T> {

    private final Class<T> attributeClass;
    @PersistenceContext
    protected EntityManager entityManager;

    public JpaGenericDaoImpl(Class<T> attributeClass) {
        this.attributeClass = attributeClass;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<T> getById(Integer attributeId) {
        T attribute = entityManager.find(attributeClass, attributeId);
        return Optional.ofNullable(attribute);
    }

    @Override
    public boolean delete(Integer objectId) {
        Query query = entityManager.createQuery("DELETE FROM " + attributeClass.getSimpleName() + " O WHERE O.id = :id", attributeClass)
                .setParameter("id", objectId);
        return query.executeUpdate() != 0;
    }

    @Override
    public T save(T category) {
        if (category.getId() == null) {
            entityManager.persist(category);
            return category;
        } else {
            return entityManager.merge(category);
        }
    }

    @Override
    public List<T> getAll() {
        return entityManager.createQuery("SELECT O from " + attributeClass.getSimpleName() + " O", attributeClass).getResultList();
    }
}
