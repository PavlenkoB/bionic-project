package ua.ho.godex.service;

import ua.ho.godex.domain.Variant;

import java.util.List;

public interface VariantService {
    List<Variant> getAll();

    Variant getById(int variantId);

    Variant create(Variant variant);

    void update(Variant variant);

    boolean delete(Integer variantId);

}
