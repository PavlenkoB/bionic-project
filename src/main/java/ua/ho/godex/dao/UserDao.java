package ua.ho.godex.dao;

import ua.ho.godex.domain.User;

import java.util.Optional;


public interface UserDao extends GenericDao<User> {
    Optional<User> getByEmail(String email);
}
