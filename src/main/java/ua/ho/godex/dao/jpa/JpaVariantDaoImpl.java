package ua.ho.godex.dao.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.ho.godex.dao.VariantDao;
import ua.ho.godex.domain.Variant;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public class JpaVariantDaoImpl implements VariantDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Optional<Variant> getById(Integer variantId) {
        return Optional.ofNullable(entityManager.find(Variant.class,variantId));
    }

    @Override
    @Transactional
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
    @Transactional
    public boolean delete(Variant variant) {
        //todo write
        return false;
    }
}
