package ua.ho.godex.dao;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ua.ho.godex.domain.User;

import java.util.List;

import static ua.ho.godex.testdata.UserFactory.*;

public class UserDaoTest extends BaseDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void save() throws Exception {
        User newUser = getNewUser();
        User savedUser = userDao.save(newUser);
        newUser.setId(savedUser.getId());

        List<User> expected = Lists.newArrayList(getAdmin(), getUser(), getNewUser());
        List<User> actual = userDao.getAll();

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void getAll() throws Exception {
        //todo Write method
    }

    @Test
    public void getById() throws Exception {
        //todo Write method
    }

    @Test
    public void getByEmail() throws Exception {
        //todo Write method
    }

    @Test
    public void delete() throws Exception {
        //todo Write method
    }
}