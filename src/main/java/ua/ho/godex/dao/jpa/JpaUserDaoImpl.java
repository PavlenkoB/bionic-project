package ua.ho.godex.dao.jpa;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.ho.godex.dao.UserDao;
import ua.ho.godex.domain.User;

import java.util.Optional;

@Repository
@Transactional
public class JpaUserDaoImpl extends JpaGenericDaoImpl<User> implements UserDao {


    public JpaUserDaoImpl() {
        super(User.class);
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return Optional.ofNullable(
                entityManager.createQuery("SELECT u from User u WHERE u.email = :mail", User.class)
                        .setParameter("mail", email).getSingleResult()
        );
    }
}
