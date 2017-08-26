package ua.ho.godex.dao;

import ua.ho.godex.domain.Attribute;
import ua.ho.godex.domain.Variant;

import java.util.List;
import java.util.Optional;

public interface VariantDao {
    Optional<Variant> getById(Integer variantId);

    Variant save(Variant variant);

    List<Variant> getAll();

    List<Variant> getForAttribute(Integer attributeId);

    boolean delete(Variant variant);
}
