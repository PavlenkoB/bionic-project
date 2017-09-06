package ua.ho.godex.service.impl;

import org.springframework.stereotype.Service;
import ua.ho.godex.dao.UserDao;
import ua.ho.godex.domain.User;
import ua.ho.godex.service.UserService;

@Service
public class UserServiceImpl extends GenericServiceImpl<User> implements UserService {
    public UserServiceImpl(UserDao userDao) {
        super(User.class, userDao);
    }
}
