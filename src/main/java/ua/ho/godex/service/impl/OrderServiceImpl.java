package ua.ho.godex.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ho.godex.dao.OrderDao;
import ua.ho.godex.domain.Order;
import ua.ho.godex.service.OrderService;
import ua.ho.godex.util.exception.NotFoundException;

import java.util.List;

/**
 * Creator: Pavlenko Bohdan
 * Date: 02.09.2017
 * Project: supStore
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Order> getAll() {
        return orderDao.getAll();
    }

    @Override
    public Order getById(Integer orderId) {
        return orderDao.getById(orderId).
                orElseThrow(() -> new NotFoundException(String.format("ORDER с id=%d не найден", orderId)));
    }

    @Override
    public Order create(Order order) {
        return orderDao.save(order);
    }

    @Override
    public void update(Order order) {
        orderDao.save(order);
    }

    @Override
    public boolean delete(Integer orderId) {
        return orderDao.delete(orderId);
    }
}
