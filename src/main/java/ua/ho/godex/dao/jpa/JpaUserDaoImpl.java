package ua.ho.godex.dao.jpa;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.ho.godex.dao.UserDao;
import ua.ho.godex.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public class JpaUserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public User save(User user) {
        if (user.getId() == null) {
            entityManager.persist(user);
            return user;
        } else {
            return entityManager.merge(user);
        }
    }

    @Override
    public List<User> getAll() {
        Query query = entityManager.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    @Override
    public Optional<User> getById(int userId) {
        return Optional.ofNullable(entityManager.find(User.class, userId));
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return Optional.ofNullable(
                entityManager.createQuery("SELECT u from User u WHERE u.email = :mail", User.class)
                        .setParameter("mail", email).getSingleResult()
        );
    }

    @Override
    public boolean delete(Integer userId) {
        Query query = entityManager.createQuery("DELETE FROM User u WHERE u.id = :user_id", User.class);
        query.setParameter("user_id", userId);
        return query.executeUpdate() != 0;
    }
}
