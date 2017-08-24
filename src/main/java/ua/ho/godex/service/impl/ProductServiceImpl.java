package ua.ho.godex.service.impl;

import ua.ho.godex.domain.Product;
import ua.ho.godex.service.ProductService;

import java.math.BigDecimal;
import java.util.List;

/**
 * Creator: Pavlenko Bohdan
 * Date: 24.08.2017
 * Project: supStore
 */
public class ProductServiceImpl implements ProductService {
    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public List<Product> getAll(String name, BigDecimal min, BigDecimal max,  int offset, int limit) {
        return null;
    }

    @Override
    public int getCount(String name, BigDecimal min, BigDecimal max) {
        return 0;
    }

    @Override
    public Product getById(int productId) {
        return null;
    }

    @Override
    public Product create(Product product) {
        return null;
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(Integer productId) {

    }
}
