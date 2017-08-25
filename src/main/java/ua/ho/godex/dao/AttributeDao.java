package ua.ho.godex.dao;

import ua.ho.godex.domain.Attribute;
import ua.ho.godex.domain.Category;

import java.util.List;

public interface AttributeDao {
    Attribute save(Attribute attribute);

    boolean delete(Attribute attribute);

    List<Attribute> getAll();

    Attribute getById(Integer attributeId);

    List<Attribute> getAllForCategory(Integer categoryId);
}
