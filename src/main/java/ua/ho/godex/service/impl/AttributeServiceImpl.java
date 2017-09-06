package ua.ho.godex.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ho.godex.dao.AttributeDao;
import ua.ho.godex.domain.Attribute;
import ua.ho.godex.service.AttributeService;

@Service
public class AttributeServiceImpl extends GenericServiceImpl<Attribute> implements AttributeService {
    @Autowired
    public AttributeServiceImpl(AttributeDao genericDao) {
        super(Attribute.class, genericDao);
    }
}
