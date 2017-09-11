package ua.ho.godex.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ho.godex.dao.ProductDao;
import ua.ho.godex.domain.Product;
import ua.ho.godex.dto.ProductSort;
import ua.ho.godex.service.ProductService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Creator: Pavlenko Bohdan
 * Date: 24.08.2017
 * Project: supStore
 */
@Service
public class ProductServiceImpl extends GenericServiceImpl<Product> implements ProductService {

    private ProductDao productDao;

    @Autowired
    public ProductServiceImpl(ProductDao productDao) {
        super(Product.class, productDao);
        this.productDao = productDao;
    }

    @Override
    public List<Product> getAll(String name, BigDecimal min, BigDecimal max, ProductSort productSort, int offset, int limit, Integer categoryId) {
        List<Product> result = new ArrayList<>();
        switch (productSort) {
            case NAME_ASC:
            case NAME_DESC:
                result = this.productDao.getAllSortedByName(name, min, max, productSort == ProductSort.NAME_DESC, offset, limit, categoryId);
                break;
            case PRICE_ASC:
            case PRICE_DESC:
                result = this.productDao.getAllSortedByPrice(name, min, max, productSort == ProductSort.PRICE_DESC, offset, limit, categoryId);
                break;
        }
        return result;
    }


    @Override
    public int getCount(String name, BigDecimal min, BigDecimal max, Integer categoryId) {
        return productDao.getCount(name, min, max, categoryId);
    }
}
