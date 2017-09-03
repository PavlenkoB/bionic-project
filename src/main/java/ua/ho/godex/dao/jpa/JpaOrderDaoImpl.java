package ua.ho.godex.dao.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.ho.godex.dao.OrderDao;
import ua.ho.godex.domain.Order;

/**
 * Creator: Pavlenko Bohdan
 * Date: 02.09.2017
 * Project: supStore
 */
@Repository
@Transactional
public class JpaOrderDaoImpl extends JpaGenericDaoImpl<Order> implements OrderDao {
    public JpaOrderDaoImpl() {
        super(Order.class);
    }
}
