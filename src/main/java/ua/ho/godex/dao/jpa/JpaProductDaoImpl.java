package ua.ho.godex.dao.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.ho.godex.dao.ProductDao;
import ua.ho.godex.domain.Product;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public class JpaProductDaoImpl implements ProductDao {
    @Override
    public Product save(Product product) {
        return null;
        //todo write
    }

    @Override
    public List<Product> getAll() {
        return null;
        //todo write
    }

    @Override
    public Optional<Product> getById(int productId) {
        return null;
        //todo write
    }

    @Override
    public boolean delete(Integer productId) {
        return false;
        //todo write
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
