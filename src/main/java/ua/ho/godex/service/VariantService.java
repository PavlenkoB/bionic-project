package ua.ho.godex.service;

import ua.ho.godex.domain.Variant;

import java.util.List;

public interface VariantService extends GenericService<Variant> {
    List<Variant> getForAttribute(Integer attributeId);
}
