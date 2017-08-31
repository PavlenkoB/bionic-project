package ua.ho.godex.dao.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.ho.godex.dao.ProductDao;
import ua.ho.godex.domain.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public class JpaProductDaoImpl implements ProductDao {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    @Transactional
    public Product save(Product product) {
        if (product.getId() == null) {
            entityManager.persist(product);
            return product;
        } else {
            return entityManager.merge(product);
        }
    }

    @Override
    @Transactional
    public boolean delete(Integer productId) {
        Query query = entityManager.createQuery("DELETE FROM Product O WHERE O.id = :id", Product.class)
                .setParameter("id", productId);
        return query.executeUpdate() != 0;
    }

    @Override
    public List<Product> getAll() {
        return entityManager.createQuery("SELECT O from Product O", Product.class).getResultList();
    }

    @Override
    public Optional<Product> getById(int productId) {
        return Optional.ofNullable(entityManager.find(Product.class,productId));
    }

    @Override
    public List<Product> getAllForUser(Integer userId) {
        return null;
        //todo write
    }

    @Override
    public List<Product> getAllForCategory(Integer category) {
        return null;
        //todo write
    }
}
