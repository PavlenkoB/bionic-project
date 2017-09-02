package ua.ho.godex.service;


import ua.ho.godex.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();

    Product getById(int productId);

    Product create(Product product);

    void update(Product product);

    boolean delete(Integer productId);
}
