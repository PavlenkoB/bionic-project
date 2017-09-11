package ua.ho.godex.service;


import ua.ho.godex.domain.Order;

import java.util.List;

public interface OrderService extends GenericService<Order> {

    void addProductToOrder(Order currentOrder, Integer productId);

    List<Order> getAllForUser(Integer userId);
}
