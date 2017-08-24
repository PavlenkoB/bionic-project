package ua.ho.godex.service;

import ua.ho.godex.domain.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User getById(int userId);

    User create(User user);

    void update(User user);

    void delete(Integer userId);
}
