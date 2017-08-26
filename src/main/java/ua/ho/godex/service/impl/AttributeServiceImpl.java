package ua.ho.godex.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ho.godex.dao.AttributeDao;
import ua.ho.godex.domain.Attribute;
import ua.ho.godex.service.AttributeService;
import ua.ho.godex.util.exception.NotFoundException;

import java.util.List;

@Service
public class AttributeServiceImpl implements AttributeService {
    @Autowired
    AttributeDao attributeDao;

    @Override
    public List<Attribute> getAll() {
        return attributeDao.getAll();
    }

    @Override
    public Attribute getById(Integer attributeId) {
        return attributeDao.getById(attributeId).
                orElseThrow(() -> new NotFoundException(String.format("Атрибут с id=%d не найден", attributeId)));
    }

    @Override
    public Attribute create(Attribute attribute) {
        return attributeDao.save(attribute);
    }

    @Override
    public void update(Attribute attribute) {
        attributeDao.save(attribute);
    }

    @Override
    public boolean delete(Integer attributeId) {
        return attributeDao.delete(attributeId);
    }

    @Override
    public List<Attribute> getForCategory(Integer categoryId) {
        return attributeDao.getAllForCategory(categoryId);
    }
}
