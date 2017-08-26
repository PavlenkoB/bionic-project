package ua.ho.godex.dao.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.ho.godex.dao.VariantDao;
import ua.ho.godex.domain.Variant;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaVariantDaoImpl implements VariantDao {
    @Override
    public Variant getById(Integer variantId) {
        //todo write
        return null;
    }

    @Override
    public Variant save(Variant variant) {
        //todo write
        return null;
    }

    @Override
    public List<Variant> getAll() {
        //todo write
        return null;
    }

    @Override
    public List<Variant> getForAttribute(Integer attributeId) {
        //todo write
        return null;
    }

    @Override
    public boolean delete(Variant variant) {
        //todo write
        return false;
    }
}
