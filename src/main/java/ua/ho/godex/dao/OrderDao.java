package ua.ho.godex.dao;


import ua.ho.godex.domain.Order;

import java.util.List;

public interface OrderDao extends GenericDao<Order> {
    List<Order> getAllForUser(Integer userId);
}
