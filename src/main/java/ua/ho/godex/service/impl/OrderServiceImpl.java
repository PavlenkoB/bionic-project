package ua.ho.godex.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ho.godex.dao.OrderDao;
import ua.ho.godex.domain.Order;
import ua.ho.godex.service.OrderService;

/**
 * Creator: Pavlenko Bohdan
 * Date: 02.09.2017
 * Project: supStore
 */
@Service
public class OrderServiceImpl extends GenericServiceImpl<Order> implements OrderService {

    @Autowired
    public OrderServiceImpl(OrderDao orderDao) {
        super(Order.class, orderDao);
    }
}
