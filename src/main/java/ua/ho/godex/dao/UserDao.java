package ua.ho.godex.dao;

import ua.ho.godex.domain.User;

import java.util.List;
import java.util.Optional;


public interface UserDao {

    User save(User user);

    List<User> getAll();

    Optional<User> getById(int userId);

    Optional<User> getByEmail(String email);

    /**
     * Delete user from DB
     *
     * @param userId User id
     * @return 1 - if delete 1 or more, 0 - if something wrong
     */
    boolean delete(Integer userId);
}
