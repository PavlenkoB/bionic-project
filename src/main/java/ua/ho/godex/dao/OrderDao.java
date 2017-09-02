package ua.ho.godex.dao;


import ua.ho.godex.domain.Order;

import java.util.List;
import java.util.Optional;

public interface OrderDao {
    boolean delete(Integer orderId);

    Order save(Order order);

    List<Order> getAll();

    Optional<Order> getById(Integer orderId);
}
