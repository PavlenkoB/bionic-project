package ua.ho.godex.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ho.godex.dao.VariantDao;
import ua.ho.godex.domain.Variant;
import ua.ho.godex.service.VariantService;
import ua.ho.godex.util.exception.NotFoundException;

import java.util.List;

@Service
public class VariantServiceImpl implements VariantService {

    @Autowired
    VariantDao variantDao;

    @Override
    public List<Variant> getAll() {
        return variantDao.getAll();
    }

    @Override
    public Variant getById(int variantId) {
        return variantDao.getById(variantId).
                orElseThrow(() -> new NotFoundException(String.format("VARIANT с id=%d не найден", variantId)));
    }

    @Override
    public Variant create(Variant variant) {
        return variantDao.save(variant);
    }

    @Override
    public void update(Variant variant) {
        variantDao.save(variant);
    }

    @Override
    public boolean delete(Integer variantId) {
        return variantDao.delete(variantId);
    }

    @Override
    public List<Variant> getForAttribute(Integer attributeId) {
        return variantDao.getForAttribute(attributeId);
    }
}
