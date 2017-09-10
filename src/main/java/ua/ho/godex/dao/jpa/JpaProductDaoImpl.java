package ua.ho.godex.dao.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import ua.ho.godex.dao.ProductDao;
import ua.ho.godex.domain.Product;

import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

@Repository
@Transactional
public class JpaProductDaoImpl extends JpaGenericDaoImpl<Product> implements ProductDao {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public JpaProductDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        super(Product.class);
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
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

    @Override
    public List<Product> getAllSortedByName(String name, BigDecimal min, BigDecimal max, boolean desc, int offset, int limit, Integer categoryId) {
        TypedQuery<Product> query = this.entityManager.createQuery("SELECT p FROM Product p " +
                "WHERE p.name LIKE :name " +
                "AND (:min is NULL OR p.price >= :min) " +
                "AND (:max is NULL OR p.price <= :max) " +
                "AND (:catId is NULL OR p.category.id = :catId) " +
                "ORDER BY p.name " + (desc ? "DESC " : "ASC "), Product.class);

        query.setParameter("name", StringUtils.isEmpty(name) ? "%" : "%" + name + "%");
        query.setParameter("min", min);
        query.setParameter("max", max);
        query.setParameter("catId", categoryId);
        query.setFirstResult(offset);
        query.setMaxResults(limit);

        return query.getResultList();
    }

    @Override
    public List<Product> getAllSortedByPrice(String name, BigDecimal min, BigDecimal max, boolean desc, int offset, int limit, Integer categoryId) {
        TypedQuery<Product> query = this.entityManager.createQuery("SELECT p FROM Product p " +
                "WHERE p.name LIKE :name " +
                "AND (:min is NULL OR p.price >= :min) " +
                "AND (:max is NULL OR p.price <= :max) " +
                "AND (:catId is NULL OR p.category.id = :catId) " +
                "ORDER BY p.price " + (desc ? "DESC " : "ASC "), Product.class);

        query.setParameter("name", StringUtils.isEmpty(name) ? "%" : "%" + name + "%");
        query.setParameter("min", min);
        query.setParameter("max", max);
        query.setParameter("catId", categoryId);
        query.setFirstResult(offset);
        query.setMaxResults(limit);

        return query.getResultList();
    }

    @Override
    public int getCount(String name, BigDecimal min, BigDecimal max, Integer categoryId) {
        String sql = "SELECT COUNT(*) FROM products WHERE name LIKE :name " +
                (min == null ? "" : "AND price >= :min ") +
                (max == null ? "" : "AND price <= :max ") +
                (categoryId == null ? "" : "AND products.categorys_id >= :catId ");
        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("name", StringUtils.isEmpty(name) ? "%" : "%" + name + "%")
                .addValue("max", max)
                .addValue("min", min)
                .addValue("catId", categoryId);

        return namedParameterJdbcTemplate.queryForObject(sql, parameterSource, Integer.class);
    }
}
