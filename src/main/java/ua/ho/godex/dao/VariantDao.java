package ua.ho.godex.dao;

import ua.ho.godex.domain.Attribute;
import ua.ho.godex.domain.Variant;

import java.util.List;
import java.util.Optional;

public interface VariantDao {
    Variant save(Variant variant);

    boolean delete(Integer variantId);

    Optional<Variant> getById(Integer variantId);

    List<Variant> getAll();

    List<Variant> getForAttribute(Integer attributeId);
}
