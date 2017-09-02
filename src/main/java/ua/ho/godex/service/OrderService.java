package ua.ho.godex.service;


import ua.ho.godex.domain.Order;

import java.util.List;

public interface OrderService {

    List<Order> getAll();

    Order getById(Integer orderOd);

    Order create(Order order);

    void update(Order order);

    boolean delete(Integer orderOd);
}
