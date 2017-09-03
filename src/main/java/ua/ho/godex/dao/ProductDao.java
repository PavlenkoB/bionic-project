package ua.ho.godex.dao;

import ua.ho.godex.domain.Product;

import java.util.List;

public interface ProductDao extends GenericDao<Product> {
    List<Product> getAllForUser(Integer userId);

    //todo wrong is hear???
    List<Product> getAllForCategory(Integer category);
}
