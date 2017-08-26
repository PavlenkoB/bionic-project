package ua.ho.godex.service;

import ua.ho.godex.domain.Attribute;

import java.util.List;

public interface AttributeService {

    List<Attribute> getAll();

    Attribute getById(Integer categoryId);

    Attribute create(Attribute category);

    void update(Attribute category);

    boolean delete(Integer categoryId);

    List<Attribute> getForCategory(Integer categoryId);
}
