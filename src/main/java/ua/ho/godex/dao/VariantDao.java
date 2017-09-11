package ua.ho.godex.dao;

import ua.ho.godex.domain.Variant;

import java.util.List;

public interface VariantDao extends GenericDao<Variant> {
    List<Variant> getForAttribute(Integer attributeId);
}
