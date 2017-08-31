package ua.ho.godex.dao;

import ua.ho.godex.domain.Attribute;

import java.util.List;
import java.util.Optional;

public interface AttributeDao {
    Attribute save(Attribute attribute);

    boolean delete(Integer attributeId);

    List<Attribute> getAll();

    Optional<Attribute> getById(Integer attributeId);

    List<Attribute> getAllForCategory(Integer categoryId);
}
