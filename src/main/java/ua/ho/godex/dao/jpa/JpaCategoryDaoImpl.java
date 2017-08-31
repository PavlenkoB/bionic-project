package ua.ho.godex.dao.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.ho.godex.dao.CategoryDao;
import ua.ho.godex.domain.Attribute;
import ua.ho.godex.domain.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public class JpaCategoryDaoImpl implements CategoryDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public Category save(Category category) {
        if (category.getId() == null) {
            entityManager.persist(category);
            return category;
        } else {
            return entityManager.merge(category);
        }
    }

    @Override
    @Transactional
    public boolean delete(Integer categoryId) {
        Query query = entityManager.createQuery("DELETE FROM Category O WHERE O.id = :id", Category.class)
                .setParameter("id", categoryId);
        return query.executeUpdate() != 0;
    }

    @Override
    public List<Category> getAll() {
        return null;
        //todo write
    }

    @Override
    public Optional<Category> getById(Integer categoryId) {
        return Optional.ofNullable(entityManager.find(Category.class,categoryId));
    }
}
