package ua.ho.godex.dao.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.ho.godex.dao.AttributeDao;
import ua.ho.godex.domain.Attribute;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaAttributeDaoImpl implements AttributeDao {
    @Override
    public Attribute save(Attribute attribute) {
        //todo write
        return null;
    }

    @Override
    public boolean delete(Attribute attribute) {
        return false;
        //todo write
    }

    @Override
    public List<Attribute> getAll() {
        return null;
        //todo write
    }

    @Override
    public Attribute getById(Integer attributeId) {
        return null;
        //todo write
    }

    @Override
    public List<Attribute> getAllForCategory(Integer categoryId) {
        return null;
        //todo write
    }
}
