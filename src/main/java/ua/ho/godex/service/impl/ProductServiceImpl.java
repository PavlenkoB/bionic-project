package ua.ho.godex.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ho.godex.dao.ProductDao;
import ua.ho.godex.domain.Product;
import ua.ho.godex.service.ProductService;
import ua.ho.godex.util.exception.NotFoundException;

import java.util.List;

/**
 * Creator: Pavlenko Bohdan
 * Date: 24.08.2017
 * Project: supStore
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public Product getById(int productId) {
        return productDao.getById(productId).
                orElseThrow(() -> new NotFoundException(String.format("PRODUCT с id=%d не найден", productId)));
    }

    @Override
    public Product create(Product product) {
        return productDao.save(product);
    }

    @Override
    public void update(Product product) {
        productDao.save(product);
    }

    @Override
    public boolean delete(Integer productId) {
        return productDao.delete(productId);
    }
}
