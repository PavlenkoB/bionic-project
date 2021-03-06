package ua.ho.godex.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ho.godex.dao.OrderDao;
import ua.ho.godex.domain.Order;
import ua.ho.godex.domain.Product;
import ua.ho.godex.service.OrderService;
import ua.ho.godex.service.ProductService;

import java.util.List;

/**
 * Creator: Pavlenko Bohdan
 * Date: 02.09.2017
 * Project: supStore
 */
@Service
public class OrderServiceImpl extends GenericServiceImpl<Order> implements OrderService {
    final private OrderDao orderDao;
    final private ProductService productService;

    @Autowired
    public OrderServiceImpl(OrderDao orderDao, ProductService productService1) {
        super(Order.class, orderDao);
        this.orderDao = orderDao;
        this.productService = productService1;
    }

    @Override
    public void addProductToOrder(Order order, Integer productId) {
        Product newProduct = productService.getById(productId);
        order.addProduct(newProduct);
        order.setTotalAmount(order.getTotalAmount().add(newProduct.getPrice()));
    }

    @Override
    public List<Order> getAllForUser(Integer userId) {
        return orderDao.getAllForUser(userId);
    }
}
