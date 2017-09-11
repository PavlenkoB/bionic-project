package ua.ho.godex.dao;

import ua.ho.godex.domain.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductDao extends GenericDao<Product> {
    List<Product> getAllForUser(Integer userId);

    //todo wrong is hear???
    List<Product> getAllForCategory(Integer category);

    List<Product> getAllSortedByName(String name, BigDecimal min, BigDecimal max, boolean desc, int offset, int limit, Integer categoryId);

    List<Product> getAllSortedByPrice(String name, BigDecimal min, BigDecimal max, boolean desc, int offset, int limit, Integer categoryId);

    int getCount(String name, BigDecimal min, BigDecimal max, Integer categoryId);
}
