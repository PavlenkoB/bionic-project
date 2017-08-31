package ua.ho.godex.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ho.godex.dao.VariantDao;
import ua.ho.godex.domain.Variant;
import ua.ho.godex.service.VariantService;

import java.util.List;

@Service
public class VariantServiceImpl implements VariantService {

    @Autowired
    VariantDao variantDao;

    @Override
    public List<Variant> getAll() {
        return null;
        //todo write
    }

    @Override
    public Variant getById(int variantId) {
        return null;
        //todo write
    }

    @Override
    public Variant create(Variant variant) {
        return null;
        //todo write
    }

    @Override
    public void update(Variant variant) {
//todo write
    }

    @Override
    public boolean delete(Integer variantId) {
        return false;
        //todo write
    }

    @Override
    public List<Variant> getForAttribute(Integer attributeId) {
        return null;
        //todo write
    }
}
