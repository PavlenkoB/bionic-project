package ua.ho.godex.dao;

import ua.ho.godex.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDao {
    Product save(Product product);

    boolean delete(Integer productId);

    List<Product> getAll();

    Optional<Product> getById(int productId);

    List<Product> getAllForUser(Integer userId);

    //todo wrong is hear???
    List<Product> getAllForCategory(Integer category);
}
