package ua.ho.godex.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ho.godex.dao.VariantDao;
import ua.ho.godex.domain.Variant;
import ua.ho.godex.service.VariantService;

import java.util.List;

@Service
public class VariantServiceImpl extends GenericServiceImpl<Variant> implements VariantService {
    private VariantDao variantDao;

    @Autowired
    public VariantServiceImpl(VariantDao variantDao) {
        super(Variant.class, variantDao);
        this.variantDao = (VariantDao) genericDao;
    }

    @Override
    public List<Variant> getForAttribute(Integer attributeId) {
        return variantDao.getForAttribute(attributeId);
    }
}
