package ua.ho.godex.dao.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.ho.godex.dao.ProductDao;
import ua.ho.godex.domain.Product;

import java.util.List;

@Repository
@Transactional
public class JpaProductDaoImpl extends JpaGenericDaoImpl<Product> implements ProductDao {
    public JpaProductDaoImpl() {
        super(Product.class);
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
