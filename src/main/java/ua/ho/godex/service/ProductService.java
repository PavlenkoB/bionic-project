package ua.ho.godex.service;


import ua.ho.godex.domain.Product;
import ua.ho.godex.dto.ProductSort;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService extends GenericService<Product> {

    List<Product> getAll(String name, BigDecimal min, BigDecimal max, ProductSort productSort, int offset, int limit, Integer categoryId);

    int getCount(String name, BigDecimal min, BigDecimal max, Integer categoryId);
}
