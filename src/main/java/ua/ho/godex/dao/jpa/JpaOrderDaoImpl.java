package ua.ho.godex.dao.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.ho.godex.dao.OrderDao;
import ua.ho.godex.domain.Order;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

/**
 * Creator: Pavlenko Bohdan
 * Date: 02.09.2017
 * Project: supStore
 */
@Repository
@Transactional(readOnly = true)
public class JpaOrderDaoImpl implements OrderDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public Order save(Order order) {
        if (order.getId() == null) {
            entityManager.persist(order);
            return order;
        } else {
            return entityManager.merge(order);
        }
    }


    @Override
    @Transactional
    public boolean delete(Integer orderId) {
        Query query = entityManager.createQuery("DELETE FROM Order O WHERE O.id = :id", Order.class)
                .setParameter("id", orderId);
        return query.executeUpdate() != 0;
    }

    @Override
    public List<Order> getAll() {
        return entityManager.createQuery("SELECT O from Order O", Order.class).getResultList();
    }

    @Override
    public Optional<Order> getById(Integer orderId) {
        return Optional.ofNullable(entityManager.find(Order.class, orderId));
    }
}
