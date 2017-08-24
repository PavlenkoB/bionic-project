package ua.ho.godex.dao.jpa;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.ho.godex.dao.UserDao;
import ua.ho.godex.domain.User;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public class JpaUserDaoImpl implements UserDao {

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public Optional<User> getById(int userId) {
        return null;
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return null;
    }
}
