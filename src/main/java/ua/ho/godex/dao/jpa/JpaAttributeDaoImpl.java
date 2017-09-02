package ua.ho.godex.dao.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.ho.godex.dao.AttributeDao;
import ua.ho.godex.domain.Attribute;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;


@Repository
@Transactional(readOnly = true)
public class JpaAttributeDaoImpl implements AttributeDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public Attribute save(Attribute attribute) {
        if (attribute.getId() == null) {
            entityManager.persist(attribute);
            return attribute;
        } else {
            return entityManager.merge(attribute);
        }
    }

    @Override
    @Transactional
    public boolean delete(Integer attributeId) {
        Query query = entityManager.createQuery("DELETE FROM Attribute A WHERE A.id = :attribute_id", Attribute.class)
                .setParameter("attribute_id", attributeId);
        return query.executeUpdate() != 0;
    }

    @Override
    public List<Attribute> getAll() {
        return entityManager.createQuery("SELECT A from Attribute A", Attribute.class).getResultList();
    }

    @Override
    public Optional<Attribute> getById(Integer attributeId) {
        Attribute attribute = entityManager.find(Attribute.class, attributeId);
        return Optional.ofNullable(attribute);
    }

    @Override
    public List<Attribute> getAllForCategory(Integer categoryId) {
        return null;
        //todo write
    }
}
