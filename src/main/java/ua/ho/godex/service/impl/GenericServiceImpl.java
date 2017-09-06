package ua.ho.godex.service.impl;

import org.springframework.transaction.annotation.Transactional;
import ua.ho.godex.dao.GenericDao;
import ua.ho.godex.domain.AbstaractGenericDomainObj;
import ua.ho.godex.service.GenericService;
import ua.ho.godex.util.exception.NotFoundException;

import java.util.List;

/**
 * Creator: Pavlenko Bohdan
 * Date: 06.09.2017
 * Project: supStore
 */
public abstract class GenericServiceImpl<T extends AbstaractGenericDomainObj> implements GenericService<T> {
    private final Class<T> attributeClass;
    protected GenericDao genericDao;
    ;

    public GenericServiceImpl(Class<T> attributeClass, GenericDao genericDao) {
        this.attributeClass = attributeClass;
        this.genericDao = genericDao;
    }

    @Override
    public List<T> getAll() {
        return genericDao.getAll();
    }

    @Override
    @Transactional
    public T getById(Integer domainObjectId) {
        //todo cheack this
        try {
            return (T) genericDao.getById(domainObjectId).
                    orElseThrow(() -> new NotFoundException(String.format("с id=%d не найден", domainObjectId)));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        //todo del this
        return null;
    }

    @Override
    public T create(T domainObject) {
        return (T) genericDao.save(domainObject);
    }

    @Override
    public void update(T domainObject) {
        genericDao.save(domainObject);
    }

    @Override
    @Transactional
    public boolean delete(Integer domainObjectId) {
        return genericDao.delete(domainObjectId);
    }

}
