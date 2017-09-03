package ua.ho.godex.dao.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.ho.godex.dao.VariantDao;
import ua.ho.godex.domain.Variant;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public class JpaVariantDaoImpl implements VariantDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public Variant save(Variant variant) {
        if (variant.getId() == null) {
            entityManager.persist(variant);
            return variant;
        } else {
            return entityManager.merge(variant);
        }
    }

    @Override
    @Transactional
    public boolean delete(Integer variantId) {
        Query query = entityManager.createQuery("DELETE FROM Variant O WHERE O.id = :id", Variant.class)
                .setParameter("id", variantId);
        return query.executeUpdate() != 0;
    }

    @Override
    public Optional<Variant> getById(Integer variantId) {
        return Optional.ofNullable(entityManager.find(Variant.class,variantId));
    }

    @Override
    public List<Variant> getAll() {
        return entityManager.createQuery("SELECT O from Variant O", Variant.class).getResultList();
    }

    @Override
    public List<Variant> getForAttribute(Integer attributeId) {
//        Query query=entityManager.createQuery("SELECT * FROM Variant V WHERE V.")
        return null;
    }
}
