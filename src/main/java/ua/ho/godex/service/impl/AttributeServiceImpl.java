package ua.ho.godex.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ho.godex.dao.AttributeDao;
import ua.ho.godex.domain.Attribute;
import ua.ho.godex.service.AttributeService;

import java.util.List;

@Service
public class AttributeServiceImpl implements AttributeService {
    @Autowired
    AttributeDao attributeDao;

    @Override
    public List<Attribute> getAll() {
        return null;
        //todo write
    }

    @Override
    public Attribute getById(int categoryId) {
        return null;
        //todo write
    }

    @Override
    public Attribute create(Attribute category) {
        return null;
        //todo write
    }

    @Override
    public void update(Attribute category) {
        //todo write
    }

    @Override
    public boolean delete(Integer categoryId) {
        return false;
        //todo write
    }

    @Override
    public List<Attribute> getForCategory(Integer categoryId) {
        return null;
        //todo write
    }
}
