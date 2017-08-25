package ua.ho.godex.service;


import ua.ho.godex.domain.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    List<Product> getAll();

    List<Product> getAll(String name, BigDecimal min, BigDecimal max, int offset, int limit);

    int getCount(String name, BigDecimal min, BigDecimal max);

    Product getById(int productId);

    Product create(Product product);

    void update(Product product);

    boolean delete(Integer productId);
}
