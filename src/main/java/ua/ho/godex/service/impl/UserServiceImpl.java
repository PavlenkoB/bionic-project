package ua.ho.godex.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ho.godex.dao.UserDao;
import ua.ho.godex.domain.User;
import ua.ho.godex.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User getById(int userId) {
        return null;
    }

    @Override
    public User create(User user) {
        return userDao.save(user);
    }

    @Override
    public void update(User user) {
        userDao.save(user);
    }

    @Override
    public boolean delete(Integer userId) {
        return userDao.delete(userId);
    }
}
