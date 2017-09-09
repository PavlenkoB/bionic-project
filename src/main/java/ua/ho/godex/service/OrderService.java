package ua.ho.godex.service;


import ua.ho.godex.domain.Order;

public interface OrderService extends GenericService<Order> {

    void addProductToOrder(Order currentOrder, Integer productId);
}
