package ua.ho.godex.service.impl;

import org.springframework.stereotype.Service;
import ua.ho.godex.dao.ProductDao;
import ua.ho.godex.domain.Product;
import ua.ho.godex.service.ProductService;

/**
 * Creator: Pavlenko Bohdan
 * Date: 24.08.2017
 * Project: supStore
 */
@Service
public class ProductServiceImpl extends GenericServiceImpl<Product> implements ProductService {
    public ProductServiceImpl(ProductDao productDao) {
        super(Product.class, productDao);
    }
}
