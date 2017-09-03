package ua.ho.godex.dao;

import ua.ho.godex.domain.AbstaractGenericDomainObj;

import java.util.List;
import java.util.Optional;

/**
 * Creator: Pavlenko Bohdan
 * Date: 03.09.2017
 * Project: supStore
 */
public interface GenericDao<T extends AbstaractGenericDomainObj> {
    boolean delete(Integer categoryId);

    T save(T category);

    Optional<T> getById(Integer attributeId);

    List<T> getAll();
}
